package uk.nhs.digital.iframe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import uk.nhs.digital.iframe.model.PatientDemographics;
import uk.nhs.digital.iframe.service.JWTForAccessRecord;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

public class Gui {
    private JButton button1;
    private JPanel panelContent;
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JTextField nhsNumberInput;
    private JTextField odsCodeInput;
    private JTextField birthDateInput;
    private JTextField familyNameInput;
    private JTextField givenNameInput;
    private JComboBox genderInput;
//
    private JPanel patientDemographics;
    private static final Pattern DATE_TIME = Pattern.compile("-?[0-9]{4}(-(0[1-9]|1[0-2])(-(0[0-9]|[1-2][0-9]|3[0-1])(T([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]+)?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00)))?)?)?");
    private String HOST = "http://localhost:8180/auth/realms/demo/protocol/openid-connect/token";

    JWTForAccessRecord jwtForAccessRecord = new JWTForAccessRecord();
    private JFrame app;

    public Gui() throws URISyntaxException, IOException {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 18)));
                UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Verdana", Font.BOLD, 18)));


                final String username = usernameInput.getText();
                final String password = passwordInput.getText();

                if (StringUtils.isEmpty(username)) {
                    JOptionPane.showMessageDialog(null, "Username should not be null.");
                    return;
                }
                if (StringUtils.isEmpty(password)) {
                    JOptionPane.showMessageDialog(null, "Password should not be null.");
                    return;
                }


                try {
                    final JSONObject jsonObject = getToken(username, password).getObject();
                    if (!jsonObject.has("access_token")) {
                        JOptionPane.showMessageDialog(null, jsonObject.getString("error_description"));
                        return;
                    }
                    String  accessToken = jsonObject.getString("access_token");


                    final PatientDemographics patientDemographics = new PatientDemographics()
                            .withFamilyName(familyNameInput.getText())
                            .withGivenName(givenNameInput.getText())
                            .withGender(genderInput.getSelectedItem().toString())
                            .withBirthDate(birthDateInput.getText())
                            .withNhsNumber(nhsNumberInput.getText())
                            .withOdsCode(odsCodeInput.getText());

                    final String jwtResult = jwtForAccessRecord.getJWT(username, password, accessToken, patientDemographics);

                    if (!validatePatientDemographics(patientDemographics)) {
                        return;
                    }

                    System.out.println(jwtResult);
                    showWebpage("https://google.com");

                } catch (UnirestException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                    e1.printStackTrace();
                } catch (JsonProcessingException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                    e1.printStackTrace();
                }

            }
        });

    }

    private boolean validatePatientDemographics(PatientDemographics patientDemographics) {
        if (StringUtils.isEmpty(patientDemographics.getGivenName())) {
            JOptionPane.showMessageDialog(null, ErrorMessageEnum.GIVEN_NAME_EMPTY.getMessage());
        } else if (StringUtils.isEmpty(patientDemographics.getFamilyName())) {
            JOptionPane.showMessageDialog(null, ErrorMessageEnum.FAMILY_NAME_EMPTY.getMessage());
        } else if (StringUtils.isEmpty(patientDemographics.getBirthDate())) {
            JOptionPane.showMessageDialog(null, ErrorMessageEnum.BIRTHDATE_EMPTY.getMessage());
        } else if (StringUtils.isEmpty(patientDemographics.getGender())) {
            JOptionPane.showMessageDialog(null, ErrorMessageEnum.GENDER_EMPTY.getMessage());
        } else if (StringUtils.isEmpty(patientDemographics.getOdsCode())) {
            JOptionPane.showMessageDialog(null, ErrorMessageEnum.ODS_CODE_EMPTY.getMessage());
        } else if (!DATE_TIME.matcher(patientDemographics.getBirthDate()).matches()) {
            JOptionPane.showMessageDialog(null, ErrorMessageEnum.BIRTHDATE_INVALID.getMessage());
        } else {
            return true;
        }
        return false;
    }


    public JsonNode getToken(String username, String password) throws UnirestException {

        final HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.post(HOST)
                .basicAuth(username, password)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("grant_type", "client_credentials").asJson();

        return jsonNodeHttpResponse.getBody();

    }

    private WebEngine webEngine;

    public static void main(String[] args) throws IOException, URISyntaxException {
        new Gui().start();

    }


    private void start() throws URISyntaxException, IOException {
        app = new JFrame("App");
        app.setContentPane(panelContent);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);

    }

    private void showWebpage(String url) {
        JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setPreferredSize(app.getPreferredSize());
        app.setContentPane(jfxPanel);
        app.pack();

        Platform.runLater(() -> {
            WebView view = new WebView();
            webEngine = view.getEngine();

            jfxPanel.setScene(new Scene(view));
        });

        Platform.runLater(() -> {
            webEngine.load(url);
        });
    }

}
