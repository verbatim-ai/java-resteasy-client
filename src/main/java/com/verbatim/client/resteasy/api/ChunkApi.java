package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.AckResponse;
import com.verbatim.client.resteasy.models.Chunk;
import com.verbatim.client.resteasy.models.ChunkListResponse;
import com.verbatim.client.resteasy.models.ChunkUpdateRequest;
import com.verbatim.client.resteasy.models.Error;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class ChunkApi {
  private ApiClient apiClient;

  public ChunkApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ChunkApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Delete a chunk
   * Remove a chunk: the row and its stored text.  **This is a hard delete and it reaches further than the chunk.** Unlike a document or a session, a chunk is not soft-deleted — there is no row left underneath and nothing to restore. The links between past answers and this chunk go with it, so those answers keep their text and lose the citation pointing here.  The document itself is untouched: its file, its summary and its other chunks stay exactly as they were. What changes is that the deleted passage can no longer be retrieved, which is the point — it is how a chunk carrying content that should never have been ingested is taken out of the index without destroying the document it came from.  Re-ingesting the document (&#x60;PUT /v1/doc/{docId}/content&#x60;) rebuilds every chunk from the file, this one included. 
   * @param chunkId ID of the chunk to delete. (required)
   * @return a {@code AckResponse}
   * @throws ApiException if fails to make API call
   */
  public AckResponse delete3(@javax.annotation.Nonnull UUID chunkId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'chunkId' is set
    if (chunkId == null) {
      throw new ApiException(400, "Missing the required parameter 'chunkId' when calling delete3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/chunk/{chunkId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "chunkId" + "\\}", apiClient.escapeString(chunkId.toString()));

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
   * Get a chunk
   * Fetch one chunk with its text.  Unlike the listings, &#x60;body&#x60; is always read here — a single storage round-trip, which is what this endpoint is for. An **empty** &#x60;body&#x60; on a row that exists is not an error and is worth acting on: it means the stored object is missing, so the chunk still matches vector searches and then contributes nothing to the answer.  &#x60;hash&#x60; is the MD5 of the text as it was pushed to storage. Comparing it against the body you just read is the cheapest integrity check there is, and searching it with &#x60;GET /v1/chunk/q?hash&#x3D;…&#x60; finds every copy of the same passage in your organization. 
   * @param chunkId ID of the chunk. (required)
   * @return a {@code Chunk}
   * @throws ApiException if fails to make API call
   */
  public Chunk get3(@javax.annotation.Nonnull UUID chunkId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'chunkId' is set
    if (chunkId == null) {
      throw new ApiException(400, "Missing the required parameter 'chunkId' when calling get3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/chunk/{chunkId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "chunkId" + "\\}", apiClient.escapeString(chunkId.toString()));

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

    GenericType<Chunk> localVarReturnType = new GenericType<Chunk>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List chunks
   * Paginate every chunk of the caller&#39;s organization.  The organization is resolved from the JWT, so there is nothing to pass and no way to ask for another tenant&#39;s chunks. A chunk belongs to an organization through its document&#39;s corpus, and it is visible exactly as long as that document is: deleting a document takes its chunks out of this API too.  Chunks come back in reading order — by document, then by the first page each one covers, then by id — so a document&#39;s chunks arrive as a contiguous block in the order they appear in the file, with its summary chunk (the one covering no page) heading the block. The id closes the ordering, so walking &#x60;pageIndex&#x60; never shows the same chunk twice nor skips one when a page split into several.  &#x60;body&#x60; is **not** included: it lives in object storage and would cost one read per row. Pass &#x60;body&#x3D;true&#x60; if you want it — the page size is then capped at 25 — or use &#x60;GET /v1/chunk/{chunkId}&#x60;, which always carries it.  To narrow the result — by corpus, document, hash, page or metadata — use &#x60;GET /v1/chunk/q&#x60;, which takes the same paging parameters. 
   * @param body Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. (optional, default to false)
   * @param pageSize Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code ChunkListResponse}
   * @throws ApiException if fails to make API call
   */
  public ChunkListResponse list6(@javax.annotation.Nullable Boolean body, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/chunk/".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "body", body));
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

    GenericType<ChunkListResponse> localVarReturnType = new GenericType<ChunkListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Search chunks
   * Find chunks of the caller&#39;s organization by corpus, document, hash, page and metadata.  Every filter is optional and they **narrow together**: a request carrying none of them returns the whole organization — the same answer as &#x60;GET /v1/chunk/&#x60; — and one carrying several returns only the chunks matching all of them.  The organization is never a parameter. It comes from the JWT and is always applied, so no combination of filters reaches another tenant&#39;s chunks.  ### Corpus and document — &#x60;corpusId&#x60;, &#x60;documentId&#x60;  Both must belong to the caller&#39;s organization, and both are checked *before* the search runs — naming one you cannot see answers &#x60;403&#x60; on the request rather than an empty page.  ### Hash — &#x60;hash&#x60;  Exact match on the MD5 of the chunk text. Equal hashes mean equal text, so this is how the same passage is found across documents: read a chunk, then search its hash with no &#x60;documentId&#x60; to see every copy of it in your organization. Sent empty (&#x60;&amp;hash&#x3D;&#x60;) it is treated as absent.  ### Page — &#x60;page&#x60;  Keeps chunks whose span **covers** that page. A chunk is built from consecutive elements and can cross page boundaries, so one covering pages 3 to 5 answers to &#x60;page&#x3D;3&#x60;, &#x60;page&#x3D;4&#x60; and &#x60;page&#x3D;5&#x60; alike. Pages are 1-based; &#x60;page&#x3D;0&#x60; is a &#x60;400&#x60;, not an empty page. Chunks belonging to no page in particular — the document summary — carry an empty span and match no &#x60;page&#x60; filter at all.  ### Metadata — &#x60;key&#x60;/&#x60;value&#x60;, or &#x60;json&#x60;  Matches chunks whose metadata **contains** the fragment (PostgreSQL&#39;s &#x60;@&gt;&#x60; operator), extra keys on the chunk being fine. Pass &#x60;key&#x60; and &#x60;value&#x60; for a single pair — they go together, one without the other is a &#x60;400&#x60; — or &#x60;json&#x60; for a raw object when the filter is nested or has several keys. &#x60;json&#x60; wins when both are supplied. &#x60;kind&#x60; is the key the platform sets: &#x60;chunk&#x60; for a piece of the document, &#x60;summary&#x60; for the generated summary.  ### Bodies — &#x60;body&#x60;  Off by default, because including them costs one storage read per row. With &#x60;body&#x3D;true&#x60; the page size is capped at 25.  ### Examples  * &#x60;?documentId&#x3D;…&#x60; — everything one document was split into, in reading order * &#x60;?documentId&#x3D;…&amp;body&#x3D;true&amp;pageSize&#x3D;10&#x60; — the same, with the text, ten at a time * &#x60;?documentId&#x3D;…&amp;page&#x3D;4&#x60; — every chunk covering page 4, including one that   starts on page 3 * &#x60;?hash&#x3D;9e107d9d372bb6826bd81d3542a419d6&#x60; — every copy of one passage in the   organization, across documents * &#x60;?corpusId&#x3D;…&amp;key&#x3D;kind&amp;value&#x3D;summary&#x60; — the summary chunk of every document in   a corpus * &#x60;?json&#x3D;{\&quot;section\&quot;:\&quot;Article 4\&quot;}&#x60; — a metadata fragment 
   * @param corpusId Keep chunks whose document belongs to this corpus. Must belong to the caller&#39;s organization. (optional)
   * @param documentId Keep chunks of this document. Must belong to the caller&#39;s organization. (optional)
   * @param hash Exact MD5 of the chunk text. Blank or omitted, the hash is not filtered. (optional)
   * @param page Keep chunks whose page span covers this page. 1-based. (optional)
   * @param key Metadata key to filter on. Goes together with &#x60;value&#x60;. (optional)
   * @param value Metadata value matching &#x60;key&#x60;. (optional)
   * @param json Raw JSON object used as the containment filter. Wins over &#x60;key&#x60;/&#x60;value&#x60; when set. (optional)
   * @param body Include each chunk&#39;s text, read from object storage. One storage read per row — off by default. (optional, default to false)
   * @param pageSize Number of items per page, 1-100 — or 1-25 when &#x60;body&#x3D;true&#x60;. (optional, default to 25)
   * @param pageIndex Zero-based page index. (optional, default to 0)
   * @return a {@code ChunkListResponse}
   * @throws ApiException if fails to make API call
   */
  public ChunkListResponse search2(@javax.annotation.Nullable UUID corpusId, @javax.annotation.Nullable UUID documentId, @javax.annotation.Nullable String hash, @javax.annotation.Nullable Integer page, @javax.annotation.Nullable String key, @javax.annotation.Nullable String value, @javax.annotation.Nullable String json, @javax.annotation.Nullable Boolean body, @javax.annotation.Nullable Integer pageSize, @javax.annotation.Nullable Integer pageIndex) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/chunk/q".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "corpusId", corpusId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "documentId", documentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "value", value));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "json", json));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "body", body));
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

    GenericType<ChunkListResponse> localVarReturnType = new GenericType<ChunkListResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a chunk
   * Patch a chunk&#39;s page span, metadata or text. Only the fields present in the body are applied; omitted fields keep their current value. Returns the full updated chunk, text included.  This is a **repair** endpoint. It exists so a chunk that ingestion got wrong can be corrected without re-processing the document, and it is worth knowing exactly what it does and does not do before reaching for it.  ### Rewriting &#x60;body&#x60; does not re-embed the chunk  The vector is the search index and it is not recomputed here. After patching the text, the chunk is still **retrieved for the text it used to hold** and is then handed to the model as the text it holds now. For a mangled character or a name to redact, that is exactly right — the passage means the same thing and is found the same way. For a rewrite, it is wrong: re-ingest the document instead (&#x60;PUT /v1/doc/{docId}/content&#x60;), which re-splits and re-embeds it.  &#x60;hash&#x60; is deliberately **not** recomputed either. It records the MD5 of what was embedded, so leaving it alone is what makes the divergence visible afterwards: a chunk whose &#x60;hash&#x60; no longer matches its &#x60;body&#x60; is one that has been patched.  ### &#x60;metadata&#x60; replaces, it does not merge  Send the whole object you want stored. &#x60;{}&#x60; clears it.  ### &#x60;pages&#x60; is a span  1-based page numbers, sorted and de-duplicated server-side. &#x60;[]&#x60; clears the span, which is what a chunk belonging to no page in particular carries. A value below 1 is a &#x60;400&#x60;. 
   * @param chunkId ID of the chunk to update. (required)
   * @param chunkUpdateRequest  (required)
   * @return a {@code Chunk}
   * @throws ApiException if fails to make API call
   */
  public Chunk update3(@javax.annotation.Nonnull UUID chunkId, @javax.annotation.Nonnull ChunkUpdateRequest chunkUpdateRequest) throws ApiException {
    Object localVarPostBody = chunkUpdateRequest;
    
    // verify the required parameter 'chunkId' is set
    if (chunkId == null) {
      throw new ApiException(400, "Missing the required parameter 'chunkId' when calling update3");
    }
    
    // verify the required parameter 'chunkUpdateRequest' is set
    if (chunkUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'chunkUpdateRequest' when calling update3");
    }
    
    // create path and map variables
    String localVarPath = "/v1/chunk/{chunkId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "chunkId" + "\\}", apiClient.escapeString(chunkId.toString()));

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

    GenericType<Chunk> localVarReturnType = new GenericType<Chunk>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
