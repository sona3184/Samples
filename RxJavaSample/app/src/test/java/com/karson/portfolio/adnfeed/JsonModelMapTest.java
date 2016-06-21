package com.karson.portfolio.adnfeed;

import com.karson.portfolio.adnfeed.model.AppNetData;
import com.karson.portfolio.adnfeed.model.Datum;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JsonModelMapTest {

    public static final String SAMPLE_JSON = "{  \n" +
            "   \"meta\":{  \n" +
            "      \"min_id\":\"69392032\",\n" +
            "      \"code\":200,\n" +
            "      \"max_id\":\"69392051\",\n" +
            "      \"more\":true\n" +
            "   },\n" +
            "   \"data\":[  \n" +
            "      {  \n" +
            "         \"created_at\":\"2016-06-16T01:05:46Z\",\n" +
            "         \"num_stars\":0,\n" +
            "         \"num_replies\":0,\n" +
            "         \"source\":{  \n" +
            "            \"link\":\"https://buffer.com\",\n" +
            "            \"name\":\"Buffer\",\n" +
            "            \"client_id\":\"RQW8mehVHU3wLdWLWd8YH3tuYzAq29W2\"\n" +
            "         },\n" +
            "         \"text\":\"Trump Time Capsule #23: 'He's Right' #feedly http://buff.ly/1S5UTWk\",\n" +
            "         \"num_reposts\":0,\n" +
            "         \"id\":\"69392051\",\n" +
            "         \"canonical_url\":\"https://alpha.app.net/davel77/post/69392051\",\n" +
            "         \"entities\":{  \n" +
            "            \"mentions\":[  \n" +
            "\n" +
            "            ],\n" +
            "            \"hashtags\":[  \n" +
            "               {  \n" +
            "                  \"name\":\"23\",\n" +
            "                  \"len\":3,\n" +
            "                  \"pos\":19\n" +
            "               },\n" +
            "               {  \n" +
            "                  \"name\":\"feedly\",\n" +
            "                  \"len\":7,\n" +
            "                  \"pos\":37\n" +
            "               }\n" +
            "            ],\n" +
            "            \"links\":[  \n" +
            "               {  \n" +
            "                  \"url\":\"http://buff.ly/1S5UTWk\",\n" +
            "                  \"text\":\"http://buff.ly/1S5UTWk\",\n" +
            "                  \"pos\":45,\n" +
            "                  \"len\":22\n" +
            "               }\n" +
            "            ]\n" +
            "         },\n" +
            "         \"html\":\"<span itemscope=\\\"https://app.net/schemas/Post\\\">Trump Time Capsule <span data-hashtag-name=\\\"23\\\" itemprop=\\\"hashtag\\\">#23</span>: 'He's Right' <span data-hashtag-name=\\\"feedly\\\" itemprop=\\\"hashtag\\\">#feedly</span> <a href=\\\"http://buff.ly/1S5UTWk\\\">http://buff.ly/1S5UTWk</a></span>\",\n" +
            "         \"machine_only\":false,\n" +
            "         \"user\":{  \n" +
            "            \"username\":\"davel77\",\n" +
            "            \"avatar_image\":{  \n" +
            "               \"url\":\"https://d2rfichhc2fb9n.cloudfront.net/image/5/rVGgD8cSLHu1Qazb8RmAIxO6SfB7InMiOiJzMyIsImIiOiJhZG4tdXNlci1hc3NldHMiLCJrIjoiYXNzZXRzL3VzZXIvMmIvOTEvNjAvMmI5MTYwMDAwMDAwMDAwMC5qcGciLCJvIjoiIn0\",\n" +
            "               \"width\":180,\n" +
            "               \"is_default\":false,\n" +
            "               \"height\":180\n" +
            "            },\n" +
            "            \"description\":{  \n" +
            "               \"text\":\"Digital project manager. Father. Husband. Amateur Photographer. Cigar lover.\",\n" +
            "               \"html\":\"<span itemscope=\\\"https://app.net/schemas/Post\\\">Digital project manager. Father. Husband. Amateur Photographer. Cigar lover.</span>\",\n" +
            "               \"entities\":{  \n" +
            "                  \"mentions\":[  \n" +
            "\n" +
            "                  ],\n" +
            "                  \"hashtags\":[  \n" +
            "\n" +
            "                  ],\n" +
            "                  \"links\":[  \n" +
            "\n" +
            "                  ]\n" +
            "               }\n" +
            "            },\n" +
            "            \"locale\":\"en_US\",\n" +
            "            \"created_at\":\"2013-09-24T17:25:55Z\",\n" +
            "            \"canonical_url\":\"https://alpha.app.net/davel77\",\n" +
            "            \"cover_image\":{  \n" +
            "               \"url\":\"https://d2rfichhc2fb9n.cloudfront.net/image/5/kZ-JRmTbmd3WVPswTJ8Nwxzkf917InMiOiJzMyIsImIiOiJ0YXBwLWFzc2V0cyIsImsiOiJpL1UvaS9ZL1VpWW5xRFNvTUtyTEhLNXA0OHN2NkxmTmRVMC5qcGciLCJvIjoiIn0\",\n" +
            "               \"width\":960,\n" +
            "               \"is_default\":true,\n" +
            "               \"height\":260\n" +
            "            },\n" +
            "            \"timezone\":\"America/Los_Angeles\",\n" +
            "            \"counts\":{  \n" +
            "               \"following\":18,\n" +
            "               \"posts\":1298,\n" +
            "               \"followers\":0,\n" +
            "               \"stars\":0\n" +
            "            },\n" +
            "            \"type\":\"human\",\n" +
            "            \"id\":\"170733\",\n" +
            "            \"name\":\"David Leder\"\n" +
            "         },\n" +
            "         \"thread_id\":\"69392051\",\n" +
            "         \"pagination_id\":\"69392051\"\n" +
            "      }\n" +
            "   ]\n" +
            "}";
    @Test
    public void testJsonToPojoMapping() throws Exception {

        Gson gson = new Gson();
        AppNetData data = gson.fromJson(SAMPLE_JSON, AppNetData.class);
        for(Datum datum : data.getData()) {
            //Just check the fields needed for this test project
            assertNotNull(datum.getUser().getAvatarImage().getUrl());
            assertNotNull(datum.getUser().getUsername());
            assertNotNull(datum.getText());
            assertNotNull(datum.getId());
            assertNotNull(datum.getCreatedAt());
        }
    }
}