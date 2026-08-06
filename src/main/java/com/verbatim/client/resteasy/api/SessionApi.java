package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Error;
import com.verbatim.client.resteasy.models.Session;
import com.verbatim.client.resteasy.models.SessionCreateRequest;
import com.verbatim.client.resteasy.models.SessionCreateResponse;
import com.verbatim.client.resteasy.models.SessionListResponse;
import com.verbatim.client.resteasy.models.SessionUpdateRequest;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.24.0")
public class SessionApi {
  private ApiClient apiClient;

  public SessionApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SessionApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create a session
   * Open a new conversation session against one or more corpora. The session is attached to the user carried by the caller&#39;s JWT. The model, system prompt, temperature and thinking flag are locked at creation time and apply to every post in the session.
   * @param sessionCreateRequest  (required)
   * @return a {@code SessionCreateResponse}
   * @throws ApiException if fails to make API call
   */
  public SessionCreateResponse create(@javax.annotation.Nonnull SessionCreateRequest sessionCreateRequest) throws ApiException {
    Object localVarPostBody = sessionCreateRequest;
    
    // verify the required parameter 'sessionCreateRequest' is set
    if (sessionCreateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionCreateRequest' when calling create");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/".replaceAll("\\{format\\}","json");

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

    GenericType<SessionCreateResponse> localVarReturnType = new GenericType<SessionCreateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a session
   * Soft-delete a session. **Cascades** to every post in the session (also soft-deleted). Documents and embeddings are **not** affected.
   * @param sessionId ID of the session to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete(@javax.annotation.Nonnull UUID sessionId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling delete");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/{sessionId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "sessionId" + "\\}", apiClient.escapeString(sessionId.toString()));

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
   * Get a session
   * Fetch a session&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
   * @param sessionId ID of the session. (required)
   * @return a {@code Session}
   * @throws ApiException if fails to make API call
   */
  public Session get(@javax.annotation.Nonnull UUID sessionId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling get");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/{sessionId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "sessionId" + "\\}", apiClient.escapeString(sessionId.toString()));

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

    GenericType<Session> localVarReturnType = new GenericType<Session>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List sessions attached to a corpus
   * Paginate the sessions opened against a corpus, newest first. The corpus must belong to the caller&#39;s organization.
   * @param corpusId ID of the corpus. (required)
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code SessionListResponse}
   * @throws ApiException if fails to make API call
   */
  public SessionListResponse list1(@javax.annotation.Nonnull UUID corpusId, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling list1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/byCorpus".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "corpusId", corpusId));
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

    GenericType<SessionListResponse> localVarReturnType = new GenericType<SessionListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List sessions matching a metadata fragment
   * Paginate sessions whose metadata JSONB *contains* the provided fragment (PostgreSQL &#x60;@&gt;&#x60; operator). Results are scoped to the caller&#39;s organization. Filtering on a single key/value pair: pass &#x60;key&#x60; and &#x60;value&#x60;. For richer filtering (nested JSON, multiple keys) pass a raw JSON object as &#x60;json&#x60;.
   * @param key Metadata key to filter on. Pair with &#x60;value&#x60;. (optional)
   * @param value Metadata value matching &#x60;key&#x60;. (optional)
   * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code SessionListResponse}
   * @throws ApiException if fails to make API call
   */
  public SessionListResponse listByMetadata(@javax.annotation.Nullable String key, @javax.annotation.Nullable String value, @javax.annotation.Nullable String json, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/session/byMetadata".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "value", value));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "json", json));
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

    GenericType<SessionListResponse> localVarReturnType = new GenericType<SessionListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List every session in the caller&#39;s organization
   * Paginate every session attached to at least one corpus of the caller&#39;s organization, newest first. The organization is resolved from the JWT, no parameter is needed.
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code SessionListResponse}
   * @throws ApiException if fails to make API call
   */
  public SessionListResponse listByOrganization(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/session/byOrganization".replaceAll("\\{format\\}","json");

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

    GenericType<SessionListResponse> localVarReturnType = new GenericType<SessionListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List sessions owned by a user
   * Paginate the sessions opened by a given user identifier, newest first. Results are scoped to the caller&#39;s organization at the SQL level: only sessions attached to at least one corpus of the caller&#39;s org are returned, so a user identifier shared across tenants never leaks rows. Pass &#x60;corpusId&#x60; to further restrict results to sessions bound to that specific corpus.
   * @param userId Identifier of the user (free-form string). (required)
   * @param corpusId Optional corpus filter. When provided, only sessions bound to this corpus are returned. (optional)
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code SessionListResponse}
   * @throws ApiException if fails to make API call
   */
  public SessionListResponse listByUser(@javax.annotation.Nonnull String userId, @javax.annotation.Nullable UUID corpusId, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling listByUser");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/byUser".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "userId", userId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "corpusId", corpusId));
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

    GenericType<SessionListResponse> localVarReturnType = new GenericType<SessionListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a session
   * Patch one or more session attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated session.
   * @param sessionId ID of the session to update. (required)
   * @param sessionUpdateRequest  (required)
   * @return a {@code Session}
   * @throws ApiException if fails to make API call
   */
  public Session update(@javax.annotation.Nonnull UUID sessionId, @javax.annotation.Nonnull SessionUpdateRequest sessionUpdateRequest) throws ApiException {
    Object localVarPostBody = sessionUpdateRequest;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling update");
    }
    
    // verify the required parameter 'sessionUpdateRequest' is set
    if (sessionUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionUpdateRequest' when calling update");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/{sessionId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "sessionId" + "\\}", apiClient.escapeString(sessionId.toString()));

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

    GenericType<Session> localVarReturnType = new GenericType<Session>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
