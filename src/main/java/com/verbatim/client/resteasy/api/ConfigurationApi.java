package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.Error;
import com.verbatim.client.resteasy.models.ModelListResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class ConfigurationApi {
  private ApiClient apiClient;

  public ConfigurationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConfigurationApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * List supported LLM models
   * Return the LLM models the platform is configured to serve, each with the &#x60;id&#x60; to send and the display name, description and icon URL to present it with.  The list is the same for every caller and is not paginated: &#x60;models&#x60; holds the whole catalog, in the order it is meant to be offered, and &#x60;total&#x60; is how many that is. Preselect the first entry.  &#x60;items&#x60; repeats the same ids without the display fields, for clients written against the first version of this endpoint. It is deprecated — read &#x60;models[].id&#x60;. 
   * @return a {@code ModelListResponse}
   * @throws ApiException if fails to make API call
   */
  public ModelListResponse list7() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/config/model".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<ModelListResponse> localVarReturnType = new GenericType<ModelListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
