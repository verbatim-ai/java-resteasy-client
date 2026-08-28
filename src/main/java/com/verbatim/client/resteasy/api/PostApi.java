package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.DocumentDownloadUrl;
import com.verbatim.client.resteasy.models.DocumentPreviewUrls;
import com.verbatim.client.resteasy.models.Error;
import com.verbatim.client.resteasy.models.Post;
import com.verbatim.client.resteasy.models.PostAttachmentResponse;
import com.verbatim.client.resteasy.models.PostItemResponse;
import com.verbatim.client.resteasy.models.PostListResponse;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class PostApi {
  private ApiClient apiClient;

  public PostApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PostApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Attachments from a post
   * List the attachments from a post.
   * @param postId ID of the post. (required)
   * @return a {@code PostAttachmentResponse}
   * @throws ApiException if fails to make API call
   */
  public PostAttachmentResponse attachment(@javax.annotation.Nonnull UUID postId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'postId' is set
    if (postId == null) {
      throw new ApiException(400, "Missing the required parameter 'postId' when calling attachment");
    }
    
    // create path and map variables
    String localVarPath = "/v1/post/attachment/{postId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "postId" + "\\}", apiClient.escapeString(postId.toString()));

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

    GenericType<PostAttachmentResponse> localVarReturnType = new GenericType<PostAttachmentResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a post
   * Permanently delete a post and its attachments. Documents and embeddings referenced by the attachments are **not** affected.
   * @param postId ID of the post to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete4(@javax.annotation.Nonnull UUID postId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'postId' is set
    if (postId == null) {
      throw new ApiException(400, "Missing the required parameter 'postId' when calling delete4");
    }
    
    // create path and map variables
    String localVarPath = "/v1/post/{postId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "postId" + "\\}", apiClient.escapeString(postId.toString()));

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
   * Get a presigned download URL
   * Return a time-limited presigned URL the client can use to GET the document content directly from the storage backend (S3) — no content flows through this server.  The URL is bound to the document&#39;s content type; clients SHOULD use the returned &#x60;filename&#x60; for the local save name. 
   * @param docId ID of the document. (required)
   * @return a {@code DocumentDownloadUrl}
   * @throws ApiException if fails to make API call
   */
  public DocumentDownloadUrl downloadUrl(@javax.annotation.Nonnull UUID docId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'docId' is set
    if (docId == null) {
      throw new ApiException(400, "Missing the required parameter 'docId' when calling downloadUrl");
    }
    
    // create path and map variables
    String localVarPath = "/v1/post/attachment/{docId}/download-url".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "docId" + "\\}", apiClient.escapeString(docId.toString()));

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

    GenericType<DocumentDownloadUrl> localVarReturnType = new GenericType<DocumentDownloadUrl>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a post
   * Fetch a single post by its identifier. The response carries &#x60;attachment&#x60;, the number of source chunks behind it; the sources themselves come from &#x60;GET /v1/post/attachment/{postId}&#x60;.
   * @param postId ID of the post. (required)
   * @return a {@code Post}
   * @throws ApiException if fails to make API call
   */
  public Post get4(@javax.annotation.Nonnull UUID postId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'postId' is set
    if (postId == null) {
      throw new ApiException(400, "Missing the required parameter 'postId' when calling get4");
    }
    
    // create path and map variables
    String localVarPath = "/v1/post/{postId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "postId" + "\\}", apiClient.escapeString(postId.toString()));

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

    GenericType<Post> localVarReturnType = new GenericType<Post>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List posts
   * Paginate every post (user queries and system answers) in a session, newest first.
   * @param sessionId ID of the session. (required)
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code PostListResponse}
   * @throws ApiException if fails to make API call
   */
  public PostListResponse list3(@javax.annotation.Nonnull UUID sessionId, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling list3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/post/".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sessionId", sessionId));
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

    GenericType<PostListResponse> localVarReturnType = new GenericType<PostListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get presigned preview URLs
   * Return time-limited presigned URLs for the rendered preview images of the document.  &#x60;pages&#x60; is **required** and selects the zero-based page indices to issue URLs for: at least one, at most 10 per request — &#x60;400&#x60; otherwise. Repeat the parameter for several values (&#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;) or send them comma-separated (&#x60;pages&#x3D;0,2&#x60;). Duplicates are preserved as supplied and count towards the limit. Paginate over a long document with several calls rather than asking for every page at once.  Every index must address a page of *that* document: negatives are rejected, and so is anything at or past its page count once that count is known (&#x60;nbPages&#x60; from &#x60;GET /v1/doc/{id}&#x60;, &#x60;0&#x60; while the rendering pipeline has not reported it).  One entry is issued per (page, size) over {SMALL, MEDIUM}, so a call returns &#x60;2 × pages&#x60; entries — at most 20.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 
   * @param docId ID of the document. (required)
   * @param pages One-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document&#39;s page range. Repeat for multiple values: &#x60;pages&#x3D;1&amp;pages&#x3D;2&#x60;. (required)
   * @return a {@code DocumentPreviewUrls}
   * @throws ApiException if fails to make API call
   */
  public DocumentPreviewUrls previewUrls(@javax.annotation.Nonnull UUID docId, @javax.annotation.Nonnull List<Integer> pages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'docId' is set
    if (docId == null) {
      throw new ApiException(400, "Missing the required parameter 'docId' when calling previewUrls");
    }
    
    // verify the required parameter 'pages' is set
    if (pages == null) {
      throw new ApiException(400, "Missing the required parameter 'pages' when calling previewUrls");
    }
    
    // create path and map variables
    String localVarPath = "/v1/post/attachment/{docId}/preview-urls".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "docId" + "\\}", apiClient.escapeString(docId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "pages", pages));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<DocumentPreviewUrls> localVarReturnType = new GenericType<DocumentPreviewUrls>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Send a query
   * Submit a user message to a session and run the full RAG pipeline:  1. Persist the query as a post with &#x60;owner &#x3D; USER&#x60;. 2. Vectorize the query and run a cosine-similarity search against the session&#39;s corpora. 3. Feed the top chunks to the session&#39;s LLM as context. 4. Persist the answer as a post with &#x60;owner &#x3D; SYSTEM&#x60;, with attachments pointing to the chunks used.  The response contains both the user post (&#x60;query&#x60;) and the system post (&#x60;answer&#x60;).  ### Choosing an agent  How much of that pipeline runs, and how, is decided by an **agent** — retrieval width, whether the chunks are re-ranked, the system instruction, how much of the conversation is replayed, and which model answers. See &#x60;GET /v1/agent/&#x60;.  Omit &#x60;agentId&#x60; and the query runs on the platform default agent, which is what every query did before agents existed. Pass one to run this single query under a different setup:  &#x60;&#x60;&#x60; GET /v1/post/q?sessionId&#x3D;$SESSION_ID&amp;body&#x3D;What+is+the+refund+policy%3F&amp;agentId&#x3D;$AGENT_ID &#x60;&#x60;&#x60;  The choice is **per query, not per session** — the next query on the same session is independent, so a client can escalate one question to a wider, slower agent without changing the conversation it belongs to.  The agent is then recorded on the answer as &#x60;agentId&#x60;, and only on the answer: the user&#39;s question is not something an agent produced. A missing &#x60;agentId&#x60; on an answer therefore means \&quot;ran on the default agent\&quot;, not \&quot;unknown\&quot;. Deleting an agent does not rewrite the answers it produced, so this still names an agent you have since deleted — resolving that id through &#x60;GET /v1/agent/{agentId}&#x60; answers &#x60;404&#x60;, which is the honest reading.  An &#x60;agentId&#x60; your organization cannot see — someone else&#39;s, or one that never existed — answers &#x60;404&#x60; and no post is written. 
   * @param sessionId ID of the session to post the query into. (required)
   * @param body User message to send to the LLM. (required)
   * @param lang ISO-639 language code used by the LLM. Defaults to &#x60;en&#x60;. (optional)
   * @param agentId Agent to run this query under. Omit to use the platform default agent. Must be one of the agents &#x60;GET /v1/agent/&#x60; lists for your organization. (optional)
   * @return a {@code PostItemResponse}
   * @throws ApiException if fails to make API call
   */
  public PostItemResponse query(@javax.annotation.Nonnull UUID sessionId, @javax.annotation.Nonnull String body, @javax.annotation.Nullable String lang, @javax.annotation.Nullable UUID agentId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling query");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling query");
    }
    
    // create path and map variables
    String localVarPath = "/v1/post/q".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sessionId", sessionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "body", body));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lang", lang));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "agentId", agentId));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<PostItemResponse> localVarReturnType = new GenericType<PostItemResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
