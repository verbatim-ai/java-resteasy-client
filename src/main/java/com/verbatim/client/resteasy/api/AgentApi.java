package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Agent;
import com.verbatim.client.resteasy.models.AgentCreateRequest;
import com.verbatim.client.resteasy.models.AgentListResponse;
import com.verbatim.client.resteasy.models.AgentUpdateRequest;
import com.verbatim.client.resteasy.models.Error;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class AgentApi {
  private ApiClient apiClient;

  public AgentApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AgentApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create an agent
   * Create a custom agent owned by your organization.  Only &#x60;name&#x60; is required — the smallest useful body is &#x60;{\&quot;name\&quot;: \&quot;...\&quot;}&#x60;, which produces an agent identical in behaviour to the platform default and free to diverge from it later. Every field you leave out either takes its column default (&#x60;topK&#x60; 5, &#x60;rerank&#x60; true, &#x60;useHistory&#x60; true, &#x60;thinkingMode&#x60; HIGH) or stays unset and tracks the platform value.  &#x60;name&#x60; must be free: not one of your own agents&#39; names, and not one carried by a platform agent (&#x60;lock: true&#x60;) either — both answer &#x60;409&#x60;. Core agents appear in your listing, so &#x60;Verbatim Default&#x60; there and &#x60;Verbatim Default&#x60; of your own would be two entries you could only tell apart by &#x60;lock&#x60;. Names are compared exactly, so &#x60;Support&#x60; and &#x60;support&#x60; are two names and &#x60;Verbatim Default v2&#x60; is free. Deleting an agent puts its name back into circulation.  &#x60;rerankModel&#x60; and &#x60;baseModel&#x60; are checked against &#x60;GET /v1/config/model&#x60; here rather than at query time, so a typo is a &#x60;400&#x60; on this request instead of a failure on every query the agent later runs.  The result is always &#x60;lock: false&#x60; and &#x60;default: false&#x60;. Core agents are seeded by the platform and cannot be created over the API. 
   * @param agentCreateRequest  (required)
   * @return a {@code Agent}
   * @throws ApiException if fails to make API call
   */
  public Agent create3(@javax.annotation.Nonnull AgentCreateRequest agentCreateRequest) throws ApiException {
    Object localVarPostBody = agentCreateRequest;
    
    // verify the required parameter 'agentCreateRequest' is set
    if (agentCreateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'agentCreateRequest' when calling create3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/agent/".replaceAll("\\{format\\}","json");

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

    GenericType<Agent> localVarReturnType = new GenericType<Agent>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete an agent
   * Delete a custom agent. From here on it is gone: absent from &#x60;GET /v1/agent/&#x60;, &#x60;404&#x60; on get, update and delete, and &#x60;404&#x60; on any query naming it — a deleted agent is indistinguishable from one that never existed.  What it does **not** do is rewrite the past. Answers already produced under this agent keep naming it in their &#x60;agentId&#x60;, so a conversation stays readable exactly as it happened. Deleting an agent changes what you can use from now on, not what already ran.  Sessions are unaffected: an agent is resolved per query, so a conversation that used this one simply carries on under the platform default.  Its &#x60;name&#x60; goes back into circulation, so a replacement can be created under the same name straight away.  Core agents (&#x60;lock: true&#x60;) cannot be deleted — that answers &#x60;400&#x60;. 
   * @param agentId ID of the agent to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete3(@javax.annotation.Nonnull UUID agentId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'agentId' is set
    if (agentId == null) {
      throw new ApiException(400, "Missing the required parameter 'agentId' when calling delete3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/agent/{agentId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "agentId" + "\\}", apiClient.escapeString(agentId.toString()));

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
   * Get an agent
   * Fetch one agent by its identifier — yours or a core one.  An id belonging to another organization answers &#x60;404&#x60;, the same as an id that does not exist: the two are deliberately indistinguishable. 
   * @param agentId ID of the agent. (required)
   * @return a {@code Agent}
   * @throws ApiException if fails to make API call
   */
  public Agent get3(@javax.annotation.Nonnull UUID agentId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'agentId' is set
    if (agentId == null) {
      throw new ApiException(400, "Missing the required parameter 'agentId' when calling get3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/agent/{agentId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "agentId" + "\\}", apiClient.escapeString(agentId.toString()));

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

    GenericType<Agent> localVarReturnType = new GenericType<Agent>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List agents
   * Paginate every agent your organization can query with: the platform&#39;s core agents merged with your own custom ones, **core first**, then by name.  There is no separate endpoint for the core catalogue — the merge is the point. Tell the two apart by &#x60;lock&#x60;: &#x60;true&#x60; is a platform agent you can read and use but not modify. A brand-new organization sees six of them, one per use case, and the single agent carrying &#x60;default: true&#x60; is the one a query that names no agent runs on. 
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code AgentListResponse}
   * @throws ApiException if fails to make API call
   */
  public AgentListResponse list1(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/agent/".replaceAll("\\{format\\}","json");

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

    GenericType<AgentListResponse> localVarReturnType = new GenericType<AgentListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update an agent
   * Patch a custom agent. Fields absent from the body keep their current value.  Because \&quot;absent\&quot; already means \&quot;leave alone\&quot;, it cannot also mean \&quot;put this back to the platform default\&quot; — that is what &#x60;reset&#x60; is for. List the nullable fields you want un-set and they go back to tracking the platform value:  &#x60;&#x60;&#x60;json { \&quot;topK\&quot;: 12, \&quot;reset\&quot;: [\&quot;spirit\&quot;, \&quot;temperature\&quot;] } &#x60;&#x60;&#x60;  &#x60;reset&#x60; runs after the rest of the body, so a field named in both ends up cleared.  Renaming onto a name another of your agents holds, or one a platform agent carries, answers &#x60;409&#x60;. Sending this agent&#39;s own current name does not — an unchanged name is not a rename, so a client that echoes the whole object back is unaffected.  Core agents (&#x60;lock: true&#x60;) belong to the platform and every organization sees the same row — patching one answers &#x60;400&#x60;. 
   * @param agentId ID of the agent to update. (required)
   * @param agentUpdateRequest  (required)
   * @return a {@code Agent}
   * @throws ApiException if fails to make API call
   */
  public Agent update3(@javax.annotation.Nonnull UUID agentId, @javax.annotation.Nonnull AgentUpdateRequest agentUpdateRequest) throws ApiException {
    Object localVarPostBody = agentUpdateRequest;
    
    // verify the required parameter 'agentId' is set
    if (agentId == null) {
      throw new ApiException(400, "Missing the required parameter 'agentId' when calling update3");
    }
    
    // verify the required parameter 'agentUpdateRequest' is set
    if (agentUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'agentUpdateRequest' when calling update3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/agent/{agentId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "agentId" + "\\}", apiClient.escapeString(agentId.toString()));

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

    GenericType<Agent> localVarReturnType = new GenericType<Agent>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
