package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Error;
import com.verbatim.client.resteasy.models.UserOnboardResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class UserApi {
  private ApiClient apiClient;

  public UserApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UserApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Assert an email free from registration
   * Check if the email is unknown and can be go throw signin process
   * @param email Email to assert (required)
   * @param turnstileToken turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service (required)
   * @param languageCode Email verification code language code  (optional, default to en)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse assertEmail(@javax.annotation.Nonnull String email, @javax.annotation.Nonnull String turnstileToken, @javax.annotation.Nullable String languageCode) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'email' is set
    if (email == null) {
      throw new ApiException(400, "Missing the required parameter 'email' when calling assertEmail");
    }
    
    // verify the required parameter 'turnstileToken' is set
    if (turnstileToken == null) {
      throw new ApiException(400, "Missing the required parameter 'turnstileToken' when calling assertEmail");
    }
    
    // create path and map variables
    String localVarPath = "/pub/v1/user/assert/email/{email}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "email" + "\\}", apiClient.escapeString(email.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "languageCode", languageCode));

    if (turnstileToken != null)
      localVarHeaderParams.put("turnstileToken", apiClient.parameterToString(turnstileToken));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<AckResponse> localVarReturnType = new GenericType<AckResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Assert email verification code
   * Assert the code sent to the email
   * @param email Email to assert (required)
   * @param code Email verification code (required)
   * @param turnstileToken turnstileToken owned by web client. Token delivered throw CloudFare Turnstile service (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse checkVerificationCode(@javax.annotation.Nonnull String email, @javax.annotation.Nonnull String code, @javax.annotation.Nonnull String turnstileToken) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'email' is set
    if (email == null) {
      throw new ApiException(400, "Missing the required parameter 'email' when calling checkVerificationCode");
    }
    
    // verify the required parameter 'code' is set
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling checkVerificationCode");
    }
    
    // verify the required parameter 'turnstileToken' is set
    if (turnstileToken == null) {
      throw new ApiException(400, "Missing the required parameter 'turnstileToken' when calling checkVerificationCode");
    }
    
    // create path and map variables
    String localVarPath = "/pub/v1/user/assert/code/{email}/{code}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "email" + "\\}", apiClient.escapeString(email.toString()))
      .replaceAll("\\{" + "code" + "\\}", apiClient.escapeString(code.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (turnstileToken != null)
      localVarHeaderParams.put("turnstileToken", apiClient.parameterToString(turnstileToken));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<AckResponse> localVarReturnType = new GenericType<AckResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Onboard the authenticated user
   * Bootstrap the caller into a Verbatim organization. Must be called with a Firebase JWT that does **not** yet carry an &#x60;oid&#x60; claim tokens already bound to an organization are rejected at the security layer (403). On success the user is provisioned, an organization is created (or joined), and the caller should refresh their Firebase token to pick up the new &#x60;oid&#x60; claim before calling any &#x60;/v1/_*&#x60; endpoint. 
   * @return a {@code UserOnboardResponse}
   * @throws ApiException if fails to make API call
   */
  public UserOnboardResponse onboard() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/_/v1/user/onboard".replaceAll("\\{format\\}","json");

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

    String[] localVarAuthNames = new String[] { "JWT" };

    GenericType<UserOnboardResponse> localVarReturnType = new GenericType<UserOnboardResponse>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
