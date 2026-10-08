package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AccessTokenCreateRequest;
import com.verbatim.client.resteasy.models.AccessTokenCreateResponse;
import com.verbatim.client.resteasy.models.AccessTokenListResponse;
import com.verbatim.client.resteasy.models.AccessTokenScopesResponse;
import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Error;
import java.util.UUID;
import com.verbatim.client.resteasy.models.WhoAmI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class AuthApi {
  private ApiClient apiClient;

  public AuthApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AuthApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create an access token
   * Mint a short-lived opaque access token for the caller&#39;s organization. Send it as the &#x60;X-Access-Token&#x60; header on &#x60;/v1/&#x60; API calls.  **The &#x60;token&#x60; value is only ever returned here.** Store it or hand it over now: the listing shows only its first characters, and no call returns it again.  - &#x60;scope&#x60; is mandatory and non-empty — a list of &#x60;DOMAIN:ACTION&#x60; entries such as   &#x60;corpus:read&#x60;. &#x60;GET /v1/auth/access-token/scopes&#x60; lists every valid entry. - &#x60;ttl&#x60; is in seconds: 3600 (1 hour) when omitted, at least 10, and no more than the   ceiling the platform sets (&#x60;app.access-token.max-ttl-seconds&#x60;, 86400 — 24 hours — by   default). A longer &#x60;ttl&#x60; is refused with a 400, not shortened. - &#x60;issuer&#x60; is a free label stored with the token and shown in the listing. - the token&#39;s &#x60;userId&#x60; and &#x60;email&#x60; are not inputs: they are the caller&#39;s own, and   what &#x60;GET /v1/auth/whoami&#x60; answers for the token. A token minted by a root user   is a root token.  Only reachable with a JWT: an access token cannot mint another. 
   * @param accessTokenCreateRequest  (required)
   * @return a {@code AccessTokenCreateResponse}
   * @throws ApiException if fails to make API call
   */
  public AccessTokenCreateResponse create3(@javax.annotation.Nonnull AccessTokenCreateRequest accessTokenCreateRequest) throws ApiException {
    Object localVarPostBody = accessTokenCreateRequest;
    
    // verify the required parameter 'accessTokenCreateRequest' is set
    if (accessTokenCreateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'accessTokenCreateRequest' when calling create3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/auth/access-token/".replaceAll("\\{format\\}","json");

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

    String[] localVarAuthNames = new String[] { "JWT" };

    GenericType<AccessTokenCreateResponse> localVarReturnType = new GenericType<AccessTokenCreateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List access tokens
   * List the access tokens of the caller&#39;s organization, newest first, with every attribute stored for them — **except the token value**, which is cut down to its first characters followed by &#x60;...&#x60;. The full value is only returned by the create call.  Expired tokens stay listed (compare &#x60;expiresAt&#x60; with the current time) until they are revoked. Use an item&#39;s &#x60;id&#x60; with &#x60;DELETE /v1/auth/access-token/id/{id}&#x60; to revoke it.  Tokens minted by a platform administrator, impersonation tokens included, are not listed.  Only reachable with a JWT. 
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code AccessTokenListResponse}
   * @throws ApiException if fails to make API call
   */
  public AccessTokenListResponse list3(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/auth/access-token/".replaceAll("\\{format\\}","json");

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

    String[] localVarAuthNames = new String[] { "JWT" };

    GenericType<AccessTokenListResponse> localVarReturnType = new GenericType<AccessTokenListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Revoke an access token by value
   * Permanently delete an access token, given its full value. Any request using this token fails immediately after revocation. An unknown value is acknowledged all the same. When you only have the listing, revoke by id instead. Only reachable with a JWT.
   * @param token access token to revoke. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse revoke(@javax.annotation.Nonnull String token) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'token' is set
    if (token == null) {
      throw new ApiException(400, "Missing the required parameter 'token' when calling revoke");
    }
    
    // create path and map variables
    String localVarPath = "/v1/auth/access-token/{token}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "token" + "\\}", apiClient.escapeString(token.toString()));

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

    GenericType<AckResponse> localVarReturnType = new GenericType<AckResponse>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Revoke an access token by id
   * Permanently delete one of the organization&#39;s access tokens, identified by the &#x60;id&#x60; the listing returns. Revocation is immediate: the next request carrying the token is refused.  An id that names no token of the caller&#39;s organization — unknown, already revoked, or another organization&#39;s — is a 404.  Only reachable with a JWT. 
   * @param id Id of the access token to revoke, as listed. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse revokeById(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling revokeById");
    }
    
    // create path and map variables
    String localVarPath = "/v1/auth/access-token/id/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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

    GenericType<AckResponse> localVarReturnType = new GenericType<AckResponse>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List the available scopes
   * Every scope an access token can be created with — the values accepted in the &#x60;scope&#x60; of &#x60;POST /v1/auth/access-token/&#x60;. Use it to build a scope picker rather than hard-coding the list.  A scope entry is &#x60;DOMAIN:ACTION&#x60;, and every domain combines with every action:  - &#x60;domains&#x60; — each domain with the API path it covers, what it gives access to, and its   scope entries, ready to group in a UI; - &#x60;actions&#x60; — each action with the HTTP methods it opens (&#x60;read&#x60; is &#x60;GET&#x60;, so running a   RAG query, &#x60;GET /v1/post/q&#x60;, needs &#x60;post:read&#x60;); - &#x60;scopes&#x60; — the flat list of every valid entry.  The catalog is the same for every organization and every caller. 
   * @return a {@code AccessTokenScopesResponse}
   * @throws ApiException if fails to make API call
   */
  public AccessTokenScopesResponse scopes() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/auth/access-token/scopes".replaceAll("\\{format\\}","json");

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

    GenericType<AccessTokenScopesResponse> localVarReturnType = new GenericType<AccessTokenScopesResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Who am I
   * Return the identity of the caller as resolved from the Bearer token: organization, user id, email and display name.  Typical use cases:  - Bootstrap a UI session after sign-in. - Verify that a token is still valid and which user it belongs to. 
   * @return a {@code WhoAmI}
   * @throws ApiException if fails to make API call
   */
  public WhoAmI whoami() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/auth/whoami".replaceAll("\\{format\\}","json");

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

    GenericType<WhoAmI> localVarReturnType = new GenericType<WhoAmI>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
