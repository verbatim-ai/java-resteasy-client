package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Document;
import com.verbatim.client.resteasy.models.DocumentDownloadUrl;
import com.verbatim.client.resteasy.models.DocumentInit;
import com.verbatim.client.resteasy.models.DocumentInitRequest;
import com.verbatim.client.resteasy.models.DocumentListResponse;
import com.verbatim.client.resteasy.models.DocumentPreviewUrls;
import com.verbatim.client.resteasy.models.DocumentStatus;
import com.verbatim.client.resteasy.models.DocumentUpdateRequest;
import com.verbatim.client.resteasy.models.Error;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.24.0")
public class DocumentApi {
  private ApiClient apiClient;

  public DocumentApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DocumentApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Commit a previously initialized upload
   * Step 2 of the upload flow. Confirms that the file has been PUT to the presigned URL returned by &#x60;POST /v1/doc/init&#x60; and **asynchronously** triggers ingestion (markdown conversion, summarization, chunking, embedding).  Before queuing, the server validates the uploaded object: it must exist, declare a supported content type, fit under the per-document size limit, and not already be present in the same corpus (duplicate detection by content hash).  The response is returned as soon as the document is moved to &#x60;PROCESSING&#x60;. Poll &#x60;GET /v1/doc/{id}/status&#x60; to observe the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.  Idempotent: committing a document already in &#x60;READY&#x60; status returns the current state unchanged. 
   * @param id ID of the document returned by &#x60;POST /v1/doc/init&#x60;. (required)
   * @return a {@code Document}
   * @throws ApiException if fails to make API call
   */
  public Document commitUpload(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling commitUpload");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}/commit".replaceAll("\\{format\\}","json")
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

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<Document> localVarReturnType = new GenericType<Document>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a document
   * Permanently remove a document from its corpus. **Cascades** to all embeddings and attachments referencing this document. This operation cannot be undone.
   * @param id ID of the document to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete1(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling delete1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}".replaceAll("\\{format\\}","json")
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

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<AckResponse> localVarReturnType = new GenericType<AckResponse>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a presigned download URL
   * Return a time-limited presigned URL the client can use to GET the document content directly from the storage backend (S3) — no content flows through this server.  The URL is bound to the document&#39;s content type; clients SHOULD use the returned &#x60;filename&#x60; for the local save name. 
   * @param id ID of the document. (required)
   * @return a {@code DocumentDownloadUrl}
   * @throws ApiException if fails to make API call
   */
  public DocumentDownloadUrl downloadUrl1(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling downloadUrl1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}/download-url".replaceAll("\\{format\\}","json")
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

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<DocumentDownloadUrl> localVarReturnType = new GenericType<DocumentDownloadUrl>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a document
   * Return the metadata of a document by its ID, including provider, language and arbitrary metadata.
   * @param id ID of the document. (required)
   * @return a {@code Document}
   * @throws ApiException if fails to make API call
   */
  public Document get1(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling get1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}".replaceAll("\\{format\\}","json")
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

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<Document> localVarReturnType = new GenericType<Document>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Initialize a direct-to-storage upload
   * Step 1 of the upload flow. Validates inputs, creates a document in &#x60;AWAITING_UPLOAD&#x60; status, and returns a single-use presigned PUT URL the client must use to push the file bytes directly to S3 — no content flows through this server.  The returned &#x60;uploadUrl&#x60; is bound to the requested &#x60;contentType&#x60;: the client MUST send a matching &#x60;Content-Type&#x60; header in the PUT request, or S3 will reject it.  After the PUT succeeds, call &#x60;POST /v1/doc/{id}/commit&#x60; to trigger ingestion.  Accepted content types are listed by &#x60;GET /v1/doc/accept&#x60;. 
   * @param documentInitRequest  (required)
   * @return a {@code DocumentInit}
   * @throws ApiException if fails to make API call
   */
  public DocumentInit initUpload(@javax.annotation.Nonnull DocumentInitRequest documentInitRequest) throws ApiException {
    Object localVarPostBody = documentInitRequest;
    
    // verify the required parameter 'documentInitRequest' is set
    if (documentInitRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'documentInitRequest' when calling initUpload");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/init".replaceAll("\\{format\\}","json");

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

    GenericType<DocumentInit> localVarReturnType = new GenericType<DocumentInit>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List documents
   * Paginate documents stored in a corpus, newest first. Pass the optional &#x60;status&#x60; filter to narrow down by lifecycle state — e.g. &#x60;status&#x3D;PENDING&#x60; returns the ingestion backlog, &#x60;status&#x3D;FAILED&#x60; returns documents that need attention.
   * @param corpusId ID of the corpus. (required)
   * @param status Optional lifecycle filter. When omitted, documents of all statuses are returned. (optional)
   * @param pageSize Number of items per page. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code DocumentListResponse}
   * @throws ApiException if fails to make API call
   */
  public DocumentListResponse list3(@javax.annotation.Nonnull UUID corpusId, @javax.annotation.Nullable String status, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling list3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "corpusId", corpusId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "status", status));
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

    GenericType<DocumentListResponse> localVarReturnType = new GenericType<DocumentListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List accepted content types
   * Return the MIME types accepted by &#x60;POST /v1/doc/init&#x60;. Use this to validate files client-side before initializing an upload.
   * @return a {@code String}
   * @throws ApiException if fails to make API call
   */
  public String listSupportedDocuments() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/doc/accept".replaceAll("\\{format\\}","json");

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

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get presigned preview URLs
   * Return time-limited presigned URLs for the rendered preview images of the document. One entry is issued per (page, size): by default the first 4 pages × {SMALL, MEDIUM}, so up to 8 entries per call.  Pass &#x60;pages&#x60; to restrict the response to specific page indices (e.g. &#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;). When omitted, pages 0–3 are used. Duplicate values are preserved as supplied.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 
   * @param id ID of the document. (required)
   * @param pages Page indices to include. When omitted, pages 0–3 are returned. Repeat for multiple values: &#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;. (optional)
   * @return a {@code DocumentPreviewUrls}
   * @throws ApiException if fails to make API call
   */
  public DocumentPreviewUrls previewUrls1(@javax.annotation.Nonnull UUID id, @javax.annotation.Nullable List<Integer> pages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling previewUrls1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}/preview-urls".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * Re-initialize a document for a new upload
   * Replace the **content** of an existing document while keeping its identity: same &#x60;id&#x60;, same &#x60;filename&#x60;, &#x60;userId&#x60;, &#x60;provider&#x60;, &#x60;lang&#x60;, &#x60;metadata&#x60; and source dates. Use &#x60;PATCH /v1/doc/{id}&#x60; to change those attributes — this endpoint only touches the file behind them.  The document must be in &#x60;READY&#x60; or &#x60;FAILED&#x60; status; any other status is rejected with &#x60;409&#x60;, since there is either nothing ingested yet or an ingestion in flight.  Everything derived from the previous content is dropped: its embeddings, its summary, and the counters filled in by ingestion (&#x60;size&#x60;, &#x60;tokens&#x60;, &#x60;nbWords&#x60;). The document moves back to &#x60;AWAITING_UPLOAD&#x60; and the response carries a fresh presigned PUT URL — the same payload as &#x60;POST /v1/doc/init&#x60;. From there the flow is unchanged: PUT the new bytes, then call &#x60;POST /v1/doc/{id}/commit&#x60;.  Two things to be aware of:  - Posts that cited this document **lose their attachments to it**, because the   citations point at the embeddings being deleted. Answers already returned to   users are not modified. - The previously uploaded file **stays in storage** until your PUT overwrites it.   Committing without uploading first therefore re-ingests the old content. 
   * @param id ID of the document whose content is being replaced. (required)
   * @return a {@code DocumentInit}
   * @throws ApiException if fails to make API call
   */
  public DocumentInit reinitUpload(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling reinitUpload");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}/init".replaceAll("\\{format\\}","json")
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

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<DocumentInit> localVarReturnType = new GenericType<DocumentInit>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a document&#39;s status
   * Lightweight polling endpoint. Returns the current lifecycle status, an optional message (typically a failure reason when &#x60;status &#x3D;&#x3D; FAILED&#x60;), and the last update timestamp. Cheaper than &#x60;GET /v1/doc/{id}&#x60; for polling between commit and the final &#x60;READY&#x60; or &#x60;FAILED&#x60; status.
   * @param id ID of the document. (required)
   * @return a {@code DocumentStatus}
   * @throws ApiException if fails to make API call
   */
  public DocumentStatus status(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling status");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}/status".replaceAll("\\{format\\}","json")
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

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<DocumentStatus> localVarReturnType = new GenericType<DocumentStatus>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a document summary
   * Return the Markdown summary generated during ingestion. Returns an empty body if the document has not been ingested yet or has no summary.
   * @param id ID of the document. (required)
   * @return a {@code String}
   * @throws ApiException if fails to make API call
   */
  public String summary(@javax.annotation.Nonnull UUID id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling summary");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}/summary".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json", "text/markdown"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a document
   * Patch the editable attributes of a document — &#x60;filename&#x60;, &#x60;docCreate&#x60;, &#x60;docUpdate&#x60; and &#x60;metadata&#x60;. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60; **replaces** the stored map when provided — merge client-side if you want to preserve existing keys.  &#x60;docCreate&#x60; and &#x60;docUpdate&#x60; describe the **source** document, not the platform row: they are yours to correct, while &#x60;createdAt&#x60; and &#x60;updatedAt&#x60; remain server-managed and cannot be set here.  Every attribute is descriptive: renaming a document does not move the stored file nor re-trigger ingestion, so embeddings and previews are left untouched. Available in any lifecycle status. 
   * @param id ID of the document to update. (required)
   * @param documentUpdateRequest  (required)
   * @return a {@code Document}
   * @throws ApiException if fails to make API call
   */
  public Document update1(@javax.annotation.Nonnull UUID id, @javax.annotation.Nonnull DocumentUpdateRequest documentUpdateRequest) throws ApiException {
    Object localVarPostBody = documentUpdateRequest;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling update1");
    }
    
    // verify the required parameter 'documentUpdateRequest' is set
    if (documentUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'documentUpdateRequest' when calling update1");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/{id}".replaceAll("\\{format\\}","json")
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<Document> localVarReturnType = new GenericType<Document>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
