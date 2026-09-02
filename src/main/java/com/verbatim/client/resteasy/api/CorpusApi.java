package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.CorpusCreateRequest;
import com.verbatim.client.resteasy.models.CorpusCreateResponse;
import com.verbatim.client.resteasy.models.CorpusItemResponse;
import com.verbatim.client.resteasy.models.CorpusListResponse;
import com.verbatim.client.resteasy.models.CorpusUpdateRequest;
import com.verbatim.client.resteasy.models.CorpusUpdateResponse;
import com.verbatim.client.resteasy.models.Error;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class CorpusApi {
  private ApiClient apiClient;

  public CorpusApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CorpusApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create a corpus
   * Create a new corpus inside an organization. The organization is taken from your token, so there is nothing to pass: a corpus needs only a name, and optionally a description and metadata.
   * @param corpusCreateRequest  (required)
   * @return a {@code CorpusCreateResponse}
   * @throws ApiException if fails to make API call
   */
  public CorpusCreateResponse create1(@javax.annotation.Nonnull CorpusCreateRequest corpusCreateRequest) throws ApiException {
    Object localVarPostBody = corpusCreateRequest;
    
    // verify the required parameter 'corpusCreateRequest' is set
    if (corpusCreateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusCreateRequest' when calling create1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/corpus/".replaceAll("\\{format\\}","json");

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

    GenericType<CorpusCreateResponse> localVarReturnType = new GenericType<CorpusCreateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a corpus
   * Permanently delete a corpus. **Cascades** to every session, post, document and embedding owned by this corpus. This operation cannot be undone.
   * @param corpusId ID of the corpus to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete2(@javax.annotation.Nonnull UUID corpusId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling delete2");
    }
    
    // create path and map variables
    String localVarPath = "/v1/corpus/{corpusId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "corpusId" + "\\}", apiClient.escapeString(corpusId.toString()));

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
   * Get a corpus
   * Fetch a corpus by its identifier.
   * @param corpusId ID of the corpus. (required)
   * @return a {@code CorpusItemResponse}
   * @throws ApiException if fails to make API call
   */
  public CorpusItemResponse get2(@javax.annotation.Nonnull UUID corpusId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling get2");
    }
    
    // create path and map variables
    String localVarPath = "/v1/corpus/{corpusId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "corpusId" + "\\}", apiClient.escapeString(corpusId.toString()));

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

    GenericType<CorpusItemResponse> localVarReturnType = new GenericType<CorpusItemResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List corpora
   * Paginate corpora belonging to an organization.
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code CorpusListResponse}
   * @throws ApiException if fails to make API call
   */
  public CorpusListResponse list1(@javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/corpus/".replaceAll("\\{format\\}","json");

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

    GenericType<CorpusListResponse> localVarReturnType = new GenericType<CorpusListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a corpus
   * Patch the name, description or metadata of an existing corpus. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60; **replaces** the stored map when provided — merge client-side if you want to preserve existing keys.  Nothing patchable here changes how the corpus behaves: retrieval and the models that answer belong to the agent named on each query, so no edit re-processes documents or affects queries already running. 
   * @param corpusId ID of the corpus to update. (required)
   * @param corpusUpdateRequest  (required)
   * @return a {@code CorpusUpdateResponse}
   * @throws ApiException if fails to make API call
   */
  public CorpusUpdateResponse update2(@javax.annotation.Nonnull UUID corpusId, @javax.annotation.Nonnull CorpusUpdateRequest corpusUpdateRequest) throws ApiException {
    Object localVarPostBody = corpusUpdateRequest;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling update2");
    }
    
    // verify the required parameter 'corpusUpdateRequest' is set
    if (corpusUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusUpdateRequest' when calling update2");
    }
    
    // create path and map variables
    String localVarPath = "/v1/corpus/{corpusId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "corpusId" + "\\}", apiClient.escapeString(corpusId.toString()));

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

    GenericType<CorpusUpdateResponse> localVarReturnType = new GenericType<CorpusUpdateResponse>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
