package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Error;
import com.verbatim.client.resteasy.models.Key;
import com.verbatim.client.resteasy.models.KeyCreateRequest;
import com.verbatim.client.resteasy.models.KeyCreateResponse;
import com.verbatim.client.resteasy.models.KeyItemResponse;
import com.verbatim.client.resteasy.models.KeyListResponse;
import com.verbatim.client.resteasy.models.KeyUpdateRequest;
import com.verbatim.client.resteasy.models.KeyUpdateResponse;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class KeyApi {
  private ApiClient apiClient;

  public KeyApi() {
    this(Configuration.getDefaultApiClient());
  }

  public KeyApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Activate a key
   * Flip an &#x60;INACTIVE&#x60; key back to &#x60;ACTIVE&#x60;. Only keys that have been published (content set) will actually verify JWTs.
   * @param keyId ID of the key to activate. (required)
   * @return a {@code Key}
   * @throws ApiException if fails to make API call
   */
  public Key activate(@javax.annotation.Nonnull UUID keyId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new ApiException(400, "Missing the required parameter 'keyId' when calling activate");
    }
    
    // create path and map variables
    String localVarPath = "/_/v1/key/{keyId}/activate".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

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

    GenericType<Key> localVarReturnType = new GenericType<Key>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Register a new key slot
   * Create an empty key entry with a name and an optional description. The key starts in &#x60;INACTIVE&#x60; state with no content — call &#x60;POST /_/v1/key/{id}/publish&#x60; to upload the PEM and activate it.
   * @param keyCreateRequest  (required)
   * @return a {@code KeyCreateResponse}
   * @throws ApiException if fails to make API call
   */
  public KeyCreateResponse create4(@javax.annotation.Nonnull KeyCreateRequest keyCreateRequest) throws ApiException {
    Object localVarPostBody = keyCreateRequest;
    
    // verify the required parameter 'keyCreateRequest' is set
    if (keyCreateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'keyCreateRequest' when calling create4");
    }
    
    // create path and map variables
    String localVarPath = "/_/v1/key/".replaceAll("\\{format\\}","json");

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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<KeyCreateResponse> localVarReturnType = new GenericType<KeyCreateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Deactivate a key
   * Flip an &#x60;ACTIVE&#x60; key to &#x60;INACTIVE&#x60;. Tokens signed with this key will no longer be accepted until it is reactivated.
   * @param keyId ID of the key to deactivate. (required)
   * @return a {@code Key}
   * @throws ApiException if fails to make API call
   */
  public Key deactivate(@javax.annotation.Nonnull UUID keyId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new ApiException(400, "Missing the required parameter 'keyId' when calling deactivate");
    }
    
    // create path and map variables
    String localVarPath = "/_/v1/key/{keyId}/deactivate".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

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

    GenericType<Key> localVarReturnType = new GenericType<Key>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a key
   * Soft-delete a key. JWT tokens signed with the deleted key will no longer be accepted.
   * @param keyId ID of the key to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete1(@javax.annotation.Nonnull UUID keyId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new ApiException(400, "Missing the required parameter 'keyId' when calling delete1");
    }
    
    // create path and map variables
    String localVarPath = "/_/v1/key/{keyId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

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

    GenericType<AckResponse> localVarReturnType = new GenericType<AckResponse>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a key
   * Fetch a single key by its identifier. The raw RSA content is never returned.
   * @param keyId ID of the key. (required)
   * @return a {@code KeyItemResponse}
   * @throws ApiException if fails to make API call
   */
  public KeyItemResponse get1(@javax.annotation.Nonnull UUID keyId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new ApiException(400, "Missing the required parameter 'keyId' when calling get1");
    }
    
    // create path and map variables
    String localVarPath = "/_/v1/key/{keyId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

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

    GenericType<KeyItemResponse> localVarReturnType = new GenericType<KeyItemResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List keys
   * Paginate keys belonging to the caller&#39;s organization. The raw RSA content is never returned.
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code KeyListResponse}
   * @throws ApiException if fails to make API call
   */
  public KeyListResponse list3(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/_/v1/key/".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageIndex", pageIndex));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<KeyListResponse> localVarReturnType = new GenericType<KeyListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Publish PEM content for a key
   * Upload the PEM-encoded RSA 2048-bit public key for a previously created slot. The content is validated and stored, and the key transitions to &#x60;ACTIVE&#x60;. Content is write-once — to rotate, create a new key and delete the old one.
   * @param keyId ID of the key to publish. (required)
   * @param body  (required)
   * @return a {@code Key}
   * @throws ApiException if fails to make API call
   */
  public Key publish(@javax.annotation.Nonnull UUID keyId, @javax.annotation.Nonnull String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new ApiException(400, "Missing the required parameter 'keyId' when calling publish");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling publish");
    }
    
    // create path and map variables
    String localVarPath = "/_/v1/key/{keyId}/publish".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

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
      "text/plain"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<Key> localVarReturnType = new GenericType<Key>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a key
   * Patch the name and/or description of an existing key. Raw RSA content, format, and state are not editable through this endpoint.
   * @param keyId ID of the key to update. (required)
   * @param keyUpdateRequest  (required)
   * @return a {@code KeyUpdateResponse}
   * @throws ApiException if fails to make API call
   */
  public KeyUpdateResponse update1(@javax.annotation.Nonnull UUID keyId, @javax.annotation.Nonnull KeyUpdateRequest keyUpdateRequest) throws ApiException {
    Object localVarPostBody = keyUpdateRequest;
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new ApiException(400, "Missing the required parameter 'keyId' when calling update1");
    }
    
    // verify the required parameter 'keyUpdateRequest' is set
    if (keyUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'keyUpdateRequest' when calling update1");
    }
    
    // create path and map variables
    String localVarPath = "/_/v1/key/{keyId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<KeyUpdateResponse> localVarReturnType = new GenericType<KeyUpdateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
