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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
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
   * List sessions
   * Paginate every session of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s sessions. A session belongs to an organization as soon as one of its corpora does.  The ordering is closed by the session id, so walking &#x60;pageIndex&#x60; never shows the same session twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every session in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/session/q&#x60;, which takes the same paging parameters. 
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code SessionListResponse}
   * @throws ApiException if fails to make API call
   */
  public SessionListResponse callList(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/session/".replaceAll("\\{format\\}","json");

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
   * Create a session
   * Open a new conversation session against one or more corpora. The session is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a session carries the corpora, the owner and whatever metadata you attach to it.
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
   * Search sessions
   * Find sessions of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/session/&#x60; — and one carrying several returns only the sessions matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s sessions.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the session was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps sessions bound to that corpus. A session may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches sessions whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the session being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the session id, so walking &#x60;pageIndex&#x60; never shows the same session twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every session that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every session opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/session/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
   * @param userId Exact identifier of the user who opened the session. Blank or omitted, the owner is not filtered. (optional)
   * @param corpusId Keep sessions bound to this corpus. Must belong to the caller&#39;s organization. (optional)
   * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
   * @param value Metadata value matching &#x60;key&#x60;. (optional)
   * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code SessionListResponse}
   * @throws ApiException if fails to make API call
   */
  public SessionListResponse search(@javax.annotation.Nullable String userId, @javax.annotation.Nullable UUID corpusId, @javax.annotation.Nullable String key, @javax.annotation.Nullable String value, @javax.annotation.Nullable String json, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/session/q".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "userId", userId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "corpusId", corpusId));
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
