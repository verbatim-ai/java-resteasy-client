package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.Error;
import java.util.UUID;
import com.verbatim.client.resteasy.models.WidgetAttachmentResponse;
import com.verbatim.client.resteasy.models.WidgetMessageResponse;
import com.verbatim.client.resteasy.models.WidgetPostsResponse;
import com.verbatim.client.resteasy.models.WidgetQueryResponse;
import com.verbatim.client.resteasy.models.WidgetSessionRequest;
import com.verbatim.client.resteasy.models.WidgetSessionRequestBody;
import com.verbatim.client.resteasy.models.WidgetSessionResponse;
import com.verbatim.client.resteasy.models.WidgetSessionResponseLegacy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class WidgetApi {
  private ApiClient apiClient;

  public WidgetApi() {
    this(Configuration.getDefaultApiClient());
  }

  public WidgetApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get source attachments of a post
   * Returns every source document that the AI cited when generating a SYSTEM post. For each document the response includes its summary, metadata, and **presigned preview URLs** for every page that was actually retrieved (1-based index). Two sizes are provided per page — &#x60;previewSmallUrl&#x60; (SMALL) and &#x60;previewSmallLarge&#x60; (MEDIUM) — so the widget can render a thumbnail and a full-size lightbox view without additional round-trips. All presigned URLs share the same &#x60;previewExpirationDate&#x60;; refresh by calling this endpoint again after expiry. The post must belong to the organisation identified by the Access Token.
   * @param postId Id of the post whose source attachments are fetched (required)
   * @return a {@code WidgetAttachmentResponse}
   * @throws ApiException if fails to make API call
   * @deprecated
   */
  @Deprecated
  public WidgetAttachmentResponse attachment(@javax.annotation.Nonnull UUID postId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'postId' is set
    if (postId == null) {
      throw new ApiException(400, "Missing the required parameter 'postId' when calling attachment");
    }
    
    // create path and map variables
    String localVarPath = "/v1/webhook/widget/attachment/{postId}".replaceAll("\\{format\\}","json")
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

    String[] localVarAuthNames = new String[] { "AccessToken" };

    GenericType<WidgetAttachmentResponse> localVarReturnType = new GenericType<WidgetAttachmentResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param lang  (required)
   * @param cid  (required)
   * @param sid  (required)
   * @return a {@code WidgetSessionResponseLegacy}
   * @throws ApiException if fails to make API call
   * @deprecated
   */
  @Deprecated
  public WidgetSessionResponseLegacy getSession(@javax.annotation.Nonnull String lang, @javax.annotation.Nonnull String cid, @javax.annotation.Nonnull UUID sid) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'lang' is set
    if (lang == null) {
      throw new ApiException(400, "Missing the required parameter 'lang' when calling getSession");
    }
    
    // verify the required parameter 'cid' is set
    if (cid == null) {
      throw new ApiException(400, "Missing the required parameter 'cid' when calling getSession");
    }
    
    // verify the required parameter 'sid' is set
    if (sid == null) {
      throw new ApiException(400, "Missing the required parameter 'sid' when calling getSession");
    }
    
    // create path and map variables
    String localVarPath = "/webhook/v1/widget/{lang}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "lang" + "\\}", apiClient.escapeString(lang.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cid", cid));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sid", sid));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<WidgetSessionResponseLegacy> localVarReturnType = new GenericType<WidgetSessionResponseLegacy>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Init a session
   * Init a new session with a context : name and a search context, defined by a list of Corpus UID
   * @param widgetSessionRequest  (required)
   * @return a {@code WidgetSessionResponse}
   * @throws ApiException if fails to make API call
   * @deprecated
   */
  @Deprecated
  public WidgetSessionResponse init(@javax.annotation.Nonnull WidgetSessionRequest widgetSessionRequest) throws ApiException {
    Object localVarPostBody = widgetSessionRequest;
    
    // verify the required parameter 'widgetSessionRequest' is set
    if (widgetSessionRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'widgetSessionRequest' when calling init");
    }
    
    // create path and map variables
    String localVarPath = "/v1/webhook/widget/init".replaceAll("\\{format\\}","json");

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

    String[] localVarAuthNames = new String[] { "AccessToken" };

    GenericType<WidgetSessionResponse> localVarReturnType = new GenericType<WidgetSessionResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param lang  (required)
   * @param cid  (required)
   * @param sid  (required)
   * @param widgetSessionRequestBody  (required)
   * @return a {@code WidgetMessageResponse}
   * @throws ApiException if fails to make API call
   * @deprecated
   */
  @Deprecated
  public WidgetMessageResponse postMessage(@javax.annotation.Nonnull String lang, @javax.annotation.Nonnull String cid, @javax.annotation.Nonnull UUID sid, @javax.annotation.Nonnull WidgetSessionRequestBody widgetSessionRequestBody) throws ApiException {
    Object localVarPostBody = widgetSessionRequestBody;
    
    // verify the required parameter 'lang' is set
    if (lang == null) {
      throw new ApiException(400, "Missing the required parameter 'lang' when calling postMessage");
    }
    
    // verify the required parameter 'cid' is set
    if (cid == null) {
      throw new ApiException(400, "Missing the required parameter 'cid' when calling postMessage");
    }
    
    // verify the required parameter 'sid' is set
    if (sid == null) {
      throw new ApiException(400, "Missing the required parameter 'sid' when calling postMessage");
    }
    
    // verify the required parameter 'widgetSessionRequestBody' is set
    if (widgetSessionRequestBody == null) {
      throw new ApiException(400, "Missing the required parameter 'widgetSessionRequestBody' when calling postMessage");
    }
    
    // create path and map variables
    String localVarPath = "/webhook/v1/widget/{lang}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "lang" + "\\}", apiClient.escapeString(lang.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cid", cid));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sid", sid));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<WidgetMessageResponse> localVarReturnType = new GenericType<WidgetMessageResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List posts in a session
   * Returns the full chronological history of a session — both user queries (&#x60;owner: USER&#x60;) and AI answers (&#x60;owner: SYSTEM&#x60;). Each item includes the message text, language, timestamp, and the number of source document chunks cited (&#x60;attachment&#x60; count). The session must belong to the organisation identified by the Access Token.
   * @param sessionId Id of the session where the posts are fetched (required)
   * @return a {@code WidgetPostsResponse}
   * @throws ApiException if fails to make API call
   * @deprecated
   */
  @Deprecated
  public WidgetPostsResponse posts(@javax.annotation.Nonnull UUID sessionId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling posts");
    }
    
    // create path and map variables
    String localVarPath = "/v1/webhook/widget/".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sessionId", sessionId));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "AccessToken" };

    GenericType<WidgetPostsResponse> localVarReturnType = new GenericType<WidgetPostsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Post a query in a session
   * User query is posted in the session. AI backend system answer to this query
   * @param sessionId Id of the session where the query is fired (required)
   * @param query The user&#39;s query (required)
   * @param lang ISO language code use by the model  (optional, default to fr)
   * @return a {@code WidgetQueryResponse}
   * @throws ApiException if fails to make API call
   * @deprecated
   */
  @Deprecated
  public WidgetQueryResponse query(@javax.annotation.Nonnull UUID sessionId, @javax.annotation.Nonnull String query, @javax.annotation.Nullable String lang) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling query");
    }
    
    // verify the required parameter 'query' is set
    if (query == null) {
      throw new ApiException(400, "Missing the required parameter 'query' when calling query");
    }
    
    // create path and map variables
    String localVarPath = "/v1/webhook/widget/q".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sessionId", sessionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lang", lang));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "AccessToken" };

    GenericType<WidgetQueryResponse> localVarReturnType = new GenericType<WidgetQueryResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
