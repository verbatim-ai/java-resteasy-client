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
import com.verbatim.client.resteasy.models.DocumentSearchResponse;
import com.verbatim.client.resteasy.models.DocumentStatus;
import com.verbatim.client.resteasy.models.DocumentUpdateRequest;
import com.verbatim.client.resteasy.models.Error;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
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
   * Step 1 of the upload flow. Validates inputs, creates a document in &#x60;AWAITING_UPLOAD&#x60; status, and returns a single-use presigned PUT URL the client must use to push the file bytes directly to S3 — no content flows through this server.  The returned &#x60;uploadUrl&#x60; is bound to the requested &#x60;contentType&#x60;: the client MUST send a matching &#x60;Content-Type&#x60; header in the PUT request, or S3 will reject it.  After the PUT succeeds, call &#x60;POST /v1/doc/{id}/commit&#x60; to trigger ingestion.  Accepted content types are listed by &#x60;GET /v1/doc/accept&#x60;.  Two optional fields shape what happens later: &#x60;tags&#x60; classifies the document so &#x60;GET /v1/doc/?tags&#x3D;…&#x60; can find it, and &#x60;chunk&#x60; overrides how ingestion splits it into embeddable pieces. &#x60;chunk&#x60; accepts the Unstructured chunking options (&#x60;strategy&#x60;, &#x60;max_characters&#x60;, &#x60;overlap&#x60;, …) — see the request schema for the full key reference, and the *Chunking* examples below for the three shapes that cover most documents. Omit &#x60;chunk&#x60; and the platform default applies (&#x60;by_title&#x60;, &#x60;max_characters: 10000&#x60;, &#x60;combine_text_under_n_chars: 1000&#x60;). 
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
   * Paginate documents stored in a corpus. Pass the optional &#x60;status&#x60; filter to narrow down by lifecycle state — e.g. &#x60;status&#x3D;PENDING&#x60; returns the ingestion backlog, &#x60;status&#x3D;FAILED&#x60; returns documents that need attention.  Pass &#x60;tags&#x60; to keep only documents carrying **at least one** of the given tags (repeat the parameter for several: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). Combining &#x60;status&#x60; and &#x60;tags&#x60; narrows on both. 
   * @param corpusId ID of the corpus. (required)
   * @param status Optional lifecycle filter. When omitted, documents of all statuses are returned. (optional)
   * @param tags Optional tag filter. Returns documents carrying at least one of the given tags. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. (optional)
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code DocumentListResponse}
   * @throws ApiException if fails to make API call
   */
  public DocumentListResponse list4(@javax.annotation.Nonnull UUID corpusId, @javax.annotation.Nullable String status, @javax.annotation.Nullable List<String> tags, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling list4");
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
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "tags", tags));
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
   * Return time-limited presigned URLs for the rendered preview images of the document.  &#x60;pages&#x60; is **required** and selects the zero-based page indices to issue URLs for: at least one, at most 10 per request — &#x60;400&#x60; otherwise. Repeat the parameter for several values (&#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;) or send them comma-separated (&#x60;pages&#x3D;0,2&#x60;). Duplicates are preserved as supplied and count towards the limit. Paginate over a long document with several calls rather than asking for every page at once.  Every index must address a page of *that* document: negatives are rejected, and so is anything at or past its page count once that count is known (&#x60;nbPages&#x60; from &#x60;GET /v1/doc/{id}&#x60;, &#x60;0&#x60; while the rendering pipeline has not reported it).  One entry is issued per (page, size) over {SMALL, MEDIUM}, so a call returns &#x60;2 × pages&#x60; entries — at most 20.  The URLs point at preview images produced asynchronously by the rendering pipeline. No existence check is performed — individual URLs MAY return 404 when fetched if the corresponding (page, size) hasn&#39;t been generated yet; clients SHOULD fall back per-tile. 
   * @param id ID of the document. (required)
   * @param pages Zero-based page indices to issue preview URLs for. Required: 1 to 10 values per request, each within the document&#39;s page range. Repeat for multiple values: &#x60;pages&#x3D;0&amp;pages&#x3D;2&#x60;. (required)
   * @return a {@code DocumentPreviewUrls}
   * @throws ApiException if fails to make API call
   */
  public DocumentPreviewUrls previewUrls1(@javax.annotation.Nonnull UUID id, @javax.annotation.Nonnull List<Integer> pages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling previewUrls1");
    }
    
    // verify the required parameter 'pages' is set
    if (pages == null) {
      throw new ApiException(400, "Missing the required parameter 'pages' when calling previewUrls1");
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
   * Replace the **content** of an existing document while keeping its identity: same &#x60;id&#x60;, same &#x60;filename&#x60;, &#x60;userId&#x60;, &#x60;provider&#x60;, &#x60;lang&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60;, &#x60;chunk&#x60; and source dates. Use &#x60;PATCH /v1/doc/{id}&#x60; to change those attributes — this endpoint only touches the file behind them.  The document must be in &#x60;READY&#x60; or &#x60;FAILED&#x60; status; any other status is rejected with &#x60;409&#x60;, since there is either nothing ingested yet or an ingestion in flight.  Everything derived from the previous content is dropped: its embeddings, its summary, and the counters filled in by ingestion (&#x60;size&#x60;, &#x60;tokens&#x60;, &#x60;nbWords&#x60;). The document moves back to &#x60;AWAITING_UPLOAD&#x60; and the response carries a fresh presigned PUT URL — the same payload as &#x60;POST /v1/doc/init&#x60;. From there the flow is unchanged: PUT the new bytes, then call &#x60;POST /v1/doc/{id}/commit&#x60;.  Two things to be aware of:  - Posts that cited this document **lose their attachments to it**, because the   citations point at the embeddings being deleted. Answers already returned to   users are not modified. - The previously uploaded file **stays in storage** until your PUT overwrites it.   Committing without uploading first therefore re-ingests the old content. 
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
   * Search documents
   * Find documents in a corpus by filename, tags, lifecycle status, content type, language, provider or ingestion date, sorted the way you need them.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole corpus, one carrying several returns only the documents matching all of them. For a plain corpus listing, &#x60;GET /v1/doc/&#x60; is the simpler endpoint — this one is for finding a document you cannot scroll to.  ### Filename — &#x60;q&#x60;  Case-insensitive, and **anchored at the start** of the filename: &#x60;q&#x3D;annual&#x60; finds &#x60;Annual-Report-2025.pdf&#x60;, &#x60;q&#x3D;report&#x60; does not. Put a &#x60;*&#x60; anywhere to match elsewhere — &#x60;q&#x3D;*report&#x60; searches any position, &#x60;q&#x3D;*report*&#x60; a substring, &#x60;q&#x3D;2025-*.pdf&#x60; a name that starts with &#x60;2025-&#x60; and ends in &#x60;.pdf&#x60;.  The default is anchored because that is the shape the index can serve: an anchored pattern is a range scan, a leading &#x60;*&#x60; is a filter over the corpus. Both are correct, the first is cheaper — prefer it when your client knows how the filename begins.  &#x60;%&#x60; and &#x60;_&#x60; carry no special meaning here: they match themselves.  ### Tags — &#x60;tags&#x60;, &#x60;tagsMatch&#x60;  Repeat the parameter for several tags (&#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;). By default (&#x60;tagsMatch&#x3D;ANY&#x60;) a document matches when it carries **at least one** of them, which is what &#x60;GET /v1/doc/?tags&#x3D;…&#x60; does; &#x60;tagsMatch&#x3D;ALL&#x60; requires **every** one of them, extra tags on the document being fine.  ### Status — &#x60;status&#x60;  Repeatable as well, and any of the listed states matches: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; returns everything that is not ingested yet or needs attention.  ### Content type — &#x60;contentType&#x60;  Repeatable too, and any of the listed types matches: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60;. Values are taken as they come — nothing is checked against &#x60;GET /v1/doc/accept&#x60;, so a type the platform does not ingest is not an error, it simply matches no document.  ### Size — &#x60;minSize&#x60;, &#x60;maxSize&#x60;  A range on the stored size in bytes, **inclusive at both ends** and each bound independent: &#x60;minSize&#x3D;1048576&#x60; alone is \&quot;at least 1 MB\&quot;, &#x60;maxSize&#x60; alone \&quot;at most\&quot;, and &#x60;minSize&#x3D;maxSize&#x3D;N&#x60; the documents of exactly that many bytes. &#x60;minSize&#x60; above &#x60;maxSize&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  A document only has a size once its upload is committed, so setting either bound also excludes everything still &#x60;AWAITING_UPLOAD&#x60; — the same documents &#x60;sort&#x3D;SIZE&#x60; pushes to the end of the result.  ### Dates — &#x60;createdAfter&#x60;, &#x60;createdBefore&#x60;  A half-open window on the ingestion date: &#x60;createdAfter&#x60; is inclusive, &#x60;createdBefore&#x60; exclusive, so consecutive windows tile the timeline without returning a document twice. Supplying &#x60;createdAfter&#x60; at or after &#x60;createdBefore&#x60; is refused with &#x60;400&#x60; rather than answering an empty page.  ### Ordering and paging  &#x60;sort&#x60; defaults to &#x60;CREATED_AT&#x60; and &#x60;order&#x60; to &#x60;DESC&#x60; — newest first. The ordering is closed by the document id, so walking &#x60;pageIndex&#x60; never shows the same document twice nor skips one, even when many documents share a sort key. Documents whose &#x60;size&#x60; is not known yet sort last whatever the direction.  &#x60;total&#x60; counts every match across all pages, not just the ones returned here.  ### Examples  * &#x60;?corpusId&#x3D;…&amp;q&#x3D;annual-report&#x60; — every document whose name starts with it * &#x60;?corpusId&#x3D;…&amp;q&#x3D;*report*&#x60; — anywhere in the name, at the cost of a scan * &#x60;?corpusId&#x3D;…&amp;q&#x3D;2025-*.pdf&#x60; — starts with &#x60;2025-&#x60;, ends in &#x60;.pdf&#x60; * &#x60;?corpusId&#x3D;…&amp;status&#x3D;FAILED&amp;status&#x3D;PENDING&amp;sort&#x3D;UPDATED_AT&amp;order&#x3D;ASC&#x60; — the   ingestion backlog, longest-waiting first * &#x60;?corpusId&#x3D;…&amp;tags&#x3D;legal&amp;tags&#x3D;2026&amp;tagsMatch&#x3D;ALL&#x60; — documents carrying both tags * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;createdAfter&#x3D;2026-07-01T00:00:00Z&amp;createdBefore&#x3D;2026-10-01T00:00:00Z&amp;sort&#x3D;SIZE&amp;order&#x3D;DESC&#x60;   — last quarter&#39;s PDFs, biggest first * &#x60;?corpusId&#x3D;…&amp;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&amp;minSize&#x3D;1048576&#x60;   — PDFs and plain text over 1 MB * &#x60;?corpusId&#x3D;…&amp;maxSize&#x3D;0&#x60; — documents that were uploaded empty 
   * @param corpusId ID of the corpus to search. (required)
   * @param q Filename pattern, case-insensitive and anchored at the start of the name: &#x60;annual&#x60; matches &#x60;Annual-Report-2025.pdf&#x60;, &#x60;report&#x60; does not. Add &#x60;*&#x60; anywhere to match elsewhere (&#x60;*report*&#x60;), at the cost of a scan over the corpus. &#x60;%&#x60; and &#x60;_&#x60; match themselves. Blank or omitted, filenames are not filtered. (optional)
   * @param tags Tag filter. Repeat for multiple values: &#x60;tags&#x3D;legal&amp;tags&#x3D;2026&#x60;. When omitted, tags are ignored. (optional)
   * @param tagsMatch How &#x60;tags&#x60; combine: &#x60;ANY&#x60; keeps documents carrying at least one of them, &#x60;ALL&#x60; only those carrying every one. Ignored without &#x60;tags&#x60;. (optional)
   * @param status Lifecycle filter. Repeat for several: &#x60;status&#x3D;PENDING&amp;status&#x3D;FAILED&#x60; matches either. When omitted, documents of all statuses are returned. (optional)
   * @param contentType MIME type filter. Repeat for several: &#x60;contentType&#x3D;application/pdf&amp;contentType&#x3D;text/plain&#x60; matches either. Values are not checked against &#x60;GET /v1/doc/accept&#x60; — an unsupported one simply matches nothing. When omitted, content types are not filtered. (optional)
   * @param lang Exact ISO-639 language code of the document. (optional)
   * @param provider Exact provider identifier, as supplied at upload time. (optional)
   * @param createdAfter Keep documents ingested at or after this instant (ISO-8601, inclusive). (optional)
   * @param createdBefore Keep documents ingested strictly before this instant (ISO-8601, exclusive). (optional)
   * @param minSize Keep documents of at least this many bytes (inclusive). Documents still awaiting upload have no size and drop out. (optional)
   * @param maxSize Keep documents of at most this many bytes (inclusive). (optional)
   * @param sort Column to sort on. Defaults to &#x60;CREATED_AT&#x60;. (optional)
   * @param order Sort direction. Defaults to &#x60;DESC&#x60; — newest, largest or alphabetically last first. (optional)
   * @param pageSize Number of items per page, 1-100. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code DocumentSearchResponse}
   * @throws ApiException if fails to make API call
   */
  public DocumentSearchResponse search(@javax.annotation.Nonnull UUID corpusId, @javax.annotation.Nullable String q, @javax.annotation.Nullable List<String> tags, @javax.annotation.Nullable String tagsMatch, @javax.annotation.Nullable List<String> status, @javax.annotation.Nullable List<String> contentType, @javax.annotation.Nullable String lang, @javax.annotation.Nullable String provider, @javax.annotation.Nullable OffsetDateTime createdAfter, @javax.annotation.Nullable OffsetDateTime createdBefore, @javax.annotation.Nullable Long minSize, @javax.annotation.Nullable Long maxSize, @javax.annotation.Nullable String sort, @javax.annotation.Nullable String order, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling search");
    }
    
    // create path and map variables
    String localVarPath = "/v1/doc/q".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "corpusId", corpusId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "q", q));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "tags", tags));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tagsMatch", tagsMatch));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "status", status));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "contentType", contentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lang", lang));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "provider", provider));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdAfter", createdAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdBefore", createdBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "minSize", minSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxSize", maxSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "order", order));
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

    GenericType<DocumentSearchResponse> localVarReturnType = new GenericType<DocumentSearchResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
   * Patch the editable attributes of a document — &#x60;filename&#x60;, &#x60;docCreate&#x60;, &#x60;docUpdate&#x60;, &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60;. Only the fields present in the request body are updated; omitted fields keep their current value.  &#x60;metadata&#x60;, &#x60;tags&#x60; and &#x60;chunk&#x60; **replace** the stored value when provided — merge client-side if you want to preserve existing entries. Send &#x60;\&quot;tags\&quot;: []&#x60; to clear every tag, and &#x60;\&quot;chunk\&quot;: {}&#x60; to drop the chunking override and fall back to the platform default.  &#x60;docCreate&#x60; and &#x60;docUpdate&#x60; describe the **source** document, not the platform row: they are yours to correct, while &#x60;createdAt&#x60; and &#x60;updatedAt&#x60; remain server-managed and cannot be set here.  Every attribute is descriptive: renaming a document does not move the stored file nor re-trigger ingestion, so embeddings and previews are left untouched. Changing &#x60;chunk&#x60; likewise applies to the **next** ingestion — it does not re-chunk an already ingested document. Available in any lifecycle status. 
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
