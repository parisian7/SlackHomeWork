package StepDefinitions.Slack;

import Utils.Driver;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class SlackAPIPostSteps {

    //WebDriver driver= Driver.getDriver();
    HttpClient httpClient;
    HttpResponse response;
    URIBuilder uriBuilder;
    public static String copy;

    @When("User Sends a massage to slack channel {string}")
    public void user_Sends_a_massage_to_slack_channel(String message) throws Exception{
        httpClient= HttpClientBuilder.create().build();
         uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("slack.com").setPath("api/chat.postMessage");
       // uriBuilder.addParameter("channel","C0164SXRETU");

        HttpPost httpPost=new HttpPost(uriBuilder.build());

        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Authorization","Bearer xoxb-941125893829-1209222336674-V71HpFW2Xr33KoX1tBuZecRV");

        HttpEntity entity=new StringEntity("{\n" +
                "  \"channel\": \"C0164SXRETU\",\n" +
                "  \"text\": \""+message+"\"\n" +
                "}");
        copy=message;
//UTQTG9TFE mymemberID
        httpPost.setEntity(entity);

         response=httpClient.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());

        //DTT7D3Z0F


    }
    @Then("User Validates the message is expectedly created")
    public void user_Validates_the_message_is_expectedly_created() throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        // https://slack.com/api/conversations.history?channel=C0164SXRETU
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("slack.com").setPath("api/conversations.history");
        uriBuilder.addParameter("channel", "C0164SXRETU");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-V71HpFW2Xr33KoX1tBuZecRV");
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> slackMap = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        List<Map<String, Object>> messageInfo = (List<Map<String, Object>>) slackMap.get("messages");
        System.out.println(messageInfo.size());
        for (int i = 0; i < messageInfo.size(); i++) {

            if(messageInfo.get(i).get("text").equals(copy)){
                System.out.println("API test is succesfull! " + messageInfo.get(i).get("text"));
            }
        }


    }
}
