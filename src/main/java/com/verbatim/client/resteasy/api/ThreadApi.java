package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Error;
import com.verbatim.client.resteasy.models.SessionCreateRequest;
import com.verbatim.client.resteasy.models.Thread;
import com.verbatim.client.resteasy.models.ThreadCreateResponse;
import com.verbatim.client.resteasy.models.ThreadListResponse;
import com.verbatim.client.resteasy.models.ThreadUpdateRequest;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class ThreadApi {
  private ApiClient apiClient;

  public ThreadApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ThreadApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * List threads
   * Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code ThreadListResponse}
   * @throws ApiException if fails to make API call
   */
  public ThreadListResponse callList(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
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

    GenericType<ThreadListResponse> localVarReturnType = new GenericType<ThreadListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create a thread
   * Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.
   * @param sessionCreateRequest  (required)
   * @return a {@code ThreadCreateResponse}
   * @throws ApiException if fails to make API call
   */
  public ThreadCreateResponse create(@javax.annotation.Nonnull SessionCreateRequest sessionCreateRequest) throws ApiException {
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

    GenericType<ThreadCreateResponse> localVarReturnType = new GenericType<ThreadCreateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create a thread
   * Open a new conversation thread against one or more corpora. The thread is attached to the user carried by the caller&#39;s JWT. How its queries are answered is not decided here: the agent named on each query decides, so a thread carries the corpora, the owner and whatever metadata you attach to it.
   * @param sessionCreateRequest  (required)
   * @return a {@code ThreadCreateResponse}
   * @throws ApiException if fails to make API call
   */
  public ThreadCreateResponse create1(@javax.annotation.Nonnull SessionCreateRequest sessionCreateRequest) throws ApiException {
    Object localVarPostBody = sessionCreateRequest;
    
    // verify the required parameter 'sessionCreateRequest' is set
    if (sessionCreateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionCreateRequest' when calling create1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/thread/".replaceAll("\\{format\\}","json");

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

    GenericType<ThreadCreateResponse> localVarReturnType = new GenericType<ThreadCreateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a thread
   * Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.
   * @param threadId ID of the thread to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete(@javax.annotation.Nonnull UUID threadId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'threadId' is set
    if (threadId == null) {
      throw new ApiException(400, "Missing the required parameter 'threadId' when calling delete");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/{threadId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "threadId" + "\\}", apiClient.escapeString(threadId.toString()));

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
   * Delete a thread
   * Soft-delete a thread. **Cascades** to every post in the thread (also soft-deleted). Documents and embeddings are **not** affected.
   * @param threadId ID of the thread to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete1(@javax.annotation.Nonnull UUID threadId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'threadId' is set
    if (threadId == null) {
      throw new ApiException(400, "Missing the required parameter 'threadId' when calling delete1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/thread/{threadId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "threadId" + "\\}", apiClient.escapeString(threadId.toString()));

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
   * Get a thread
   * Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
   * @param threadId ID of the thread. (required)
   * @return a {@code Thread}
   * @throws ApiException if fails to make API call
   */
  public Thread get(@javax.annotation.Nonnull UUID threadId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'threadId' is set
    if (threadId == null) {
      throw new ApiException(400, "Missing the required parameter 'threadId' when calling get");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/{threadId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "threadId" + "\\}", apiClient.escapeString(threadId.toString()));

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

    GenericType<Thread> localVarReturnType = new GenericType<Thread>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a thread
   * Fetch a thread&#39;s metadata (user, corpora, model, system prompt, parameters). Use &#x60;GET /v1/post&#x60; to retrieve its posts.
   * @param threadId ID of the thread. (required)
   * @return a {@code Thread}
   * @throws ApiException if fails to make API call
   */
  public Thread get1(@javax.annotation.Nonnull UUID threadId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'threadId' is set
    if (threadId == null) {
      throw new ApiException(400, "Missing the required parameter 'threadId' when calling get1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/thread/{threadId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "threadId" + "\\}", apiClient.escapeString(threadId.toString()));

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

    GenericType<Thread> localVarReturnType = new GenericType<Thread>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List threads
   * Paginate every thread of the caller&#39;s organization, newest first.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s threads. A thread belongs to an organization as soon as one of its corpora does.  The ordering is closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one when several were opened in the same millisecond. &#x60;total&#x60; counts every thread in the organization, not just those returned here.  To narrow the result — by user, by corpus, by metadata, or by any combination of the three — use &#x60;GET /v1/thread/q&#x60;, which takes the same paging parameters. 
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code ThreadListResponse}
   * @throws ApiException if fails to make API call
   */
  public ThreadListResponse list1(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/thread/".replaceAll("\\{format\\}","json");

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

    GenericType<ThreadListResponse> localVarReturnType = new GenericType<ThreadListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Search threads
   * Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
   * @param userId Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. (optional)
   * @param corpusId Keep threads bound to this corpus. Must belong to the caller&#39;s organization. (optional)
   * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
   * @param value Metadata value matching &#x60;key&#x60;. (optional)
   * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code ThreadListResponse}
   * @throws ApiException if fails to make API call
   */
  public ThreadListResponse search(@javax.annotation.Nullable String userId, @javax.annotation.Nullable UUID corpusId, @javax.annotation.Nullable String key, @javax.annotation.Nullable String value, @javax.annotation.Nullable String json, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/thread/q".replaceAll("\\{format\\}","json");

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

    GenericType<ThreadListResponse> localVarReturnType = new GenericType<ThreadListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Search threads
   * Find threads of the caller&#39;s organization by owner, corpus and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/thread/&#x60; — and one carrying several returns only the threads matching all of them. That is what this endpoint adds over the &#x60;by…&#x60; listings it replaces, which each answer one fixed combination.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s threads.  ### Owner — &#x60;userId&#x60;  Exact match on the identifier carried by the JWT when the thread was opened. Sent empty (&#x60;&amp;userId&#x3D;&#x60;) it is treated as absent rather than as a match on the empty string.  ### Corpus — &#x60;corpusId&#x60;  Keeps threads bound to that corpus. A thread may be bound to several, and it matches as soon as one of them is the requested one. The corpus must belong to the caller&#39;s organization.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches threads whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the thread being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied.  ### Ordering and paging  Newest first, closed by the thread id, so walking &#x60;pageIndex&#x60; never shows the same thread twice nor skips one. &#x60;total&#x60; counts every match across all pages.  ### Examples  * &#x60;?userId&#x3D;user_42&#x60; — every thread that user opened, across corpora * &#x60;?corpusId&#x3D;…&#x60; — every thread opened against one corpus, whoever opened it * &#x60;?userId&#x3D;user_42&amp;corpusId&#x3D;…&#x60; — both, which &#x60;GET /v1/thread/byUser&#x60; also did * &#x60;?userId&#x3D;user_42&amp;key&#x3D;customer_id&amp;value&#x3D;42&#x60; — the combination none of the   &#x60;by…&#x60; endpoints could express * &#x60;?json&#x3D;{\&quot;channel\&quot;:{\&quot;kind\&quot;:\&quot;web\&quot;}}&#x60; — a nested metadata fragment 
   * @param userId Exact identifier of the user who opened the thread. Blank or omitted, the owner is not filtered. (optional)
   * @param corpusId Keep threads bound to this corpus. Must belong to the caller&#39;s organization. (optional)
   * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
   * @param value Metadata value matching &#x60;key&#x60;. (optional)
   * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code ThreadListResponse}
   * @throws ApiException if fails to make API call
   */
  public ThreadListResponse search1(@javax.annotation.Nullable String userId, @javax.annotation.Nullable UUID corpusId, @javax.annotation.Nullable String key, @javax.annotation.Nullable String value, @javax.annotation.Nullable String json, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
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

    GenericType<ThreadListResponse> localVarReturnType = new GenericType<ThreadListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a thread
   * Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.
   * @param threadId ID of the thread to update. (required)
   * @param threadUpdateRequest  (required)
   * @return a {@code Thread}
   * @throws ApiException if fails to make API call
   */
  public Thread update(@javax.annotation.Nonnull UUID threadId, @javax.annotation.Nonnull ThreadUpdateRequest threadUpdateRequest) throws ApiException {
    Object localVarPostBody = threadUpdateRequest;
    
    // verify the required parameter 'threadId' is set
    if (threadId == null) {
      throw new ApiException(400, "Missing the required parameter 'threadId' when calling update");
    }
    
    // verify the required parameter 'threadUpdateRequest' is set
    if (threadUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'threadUpdateRequest' when calling update");
    }
    
    // create path and map variables
    String localVarPath = "/v1/session/{threadId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "threadId" + "\\}", apiClient.escapeString(threadId.toString()));

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

    GenericType<Thread> localVarReturnType = new GenericType<Thread>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a thread
   * Patch one or more thread attributes. Only the fields provided in the request body are updated; omitted fields keep their current value. Returns the full updated thread.
   * @param threadId ID of the thread to update. (required)
   * @param threadUpdateRequest  (required)
   * @return a {@code Thread}
   * @throws ApiException if fails to make API call
   */
  public Thread update1(@javax.annotation.Nonnull UUID threadId, @javax.annotation.Nonnull ThreadUpdateRequest threadUpdateRequest) throws ApiException {
    Object localVarPostBody = threadUpdateRequest;
    
    // verify the required parameter 'threadId' is set
    if (threadId == null) {
      throw new ApiException(400, "Missing the required parameter 'threadId' when calling update1");
    }
    
    // verify the required parameter 'threadUpdateRequest' is set
    if (threadUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'threadUpdateRequest' when calling update1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/thread/{threadId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "threadId" + "\\}", apiClient.escapeString(threadId.toString()));

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

    GenericType<Thread> localVarReturnType = new GenericType<Thread>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
