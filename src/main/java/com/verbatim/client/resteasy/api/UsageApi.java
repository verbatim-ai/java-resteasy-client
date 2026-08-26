package com.verbatim.client.resteasy.api;

import com.verbatim.client.resteasy.invoker.ApiException;
import com.verbatim.client.resteasy.invoker.ApiClient;
import com.verbatim.client.resteasy.invoker.Configuration;
import com.verbatim.client.resteasy.invoker.Pair;

import javax.ws.rs.core.GenericType;

import com.verbatim.client.resteasy.models.Error;
import java.util.UUID;
import com.verbatim.client.resteasy.models.Usage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.25.0")
public class UsageApi {
  private ApiClient apiClient;

  public UsageApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UsageApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Organization usage
   * Return the aggregated usage report for the caller&#39;s organization, as headline totals and as a per-bucket time series.  Each dimension is reported as: - **tokens** — &#x60;total&#x60; (lifetime, soft-deleted included) and &#x60;inPeriod&#x60; (over the reported range). At organization scope this sums &#x60;post.token&#x60; AND &#x60;document.token&#x60; (vectorization tokens are billed at organization level). - **corpora / sessions / posts / storage** — &#x60;total&#x60;, &#x60;created&#x60; and &#x60;removed&#x60; over the range. - **storage** values are bytes. - **series** — the same &#x60;created&#x60;/&#x60;removed&#x60; deltas and a &#x60;tokens&#x60; count, bucket by bucket.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
   * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
   * @return a {@code Usage}
   * @throws ApiException if fails to make API call
   */
  public Usage usage(@javax.annotation.Nullable String timeframe) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/v1/usage/all".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "timeframe", timeframe));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<Usage> localVarReturnType = new GenericType<Usage>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Corpus usage
   * Return the aggregated usage report for a single corpus, as headline totals and as a per-bucket time series.  Differences with the organization-scope report: - **tokens** sums &#x60;post.token&#x60; only — vectorization tokens (&#x60;document.token&#x60;) are reported only at organization scope, because they are billed against the org. - **corpora** is &#x60;null&#x60; — cardinality is always 1 at corpus scope. It is absent from the &#x60;series&#x60; entries too.  Sessions, posts and storage are restricted to the requested corpus.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
   * @param corpusId ID of the corpus to compute usage for. (required)
   * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
   * @return a {@code Usage}
   * @throws ApiException if fails to make API call
   */
  public Usage usageByCorpus(@javax.annotation.Nonnull UUID corpusId, @javax.annotation.Nullable String timeframe) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'corpusId' is set
    if (corpusId == null) {
      throw new ApiException(400, "Missing the required parameter 'corpusId' when calling usageByCorpus");
    }
    
    // create path and map variables
    String localVarPath = "/v1/usage/corpus/{corpusId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "corpusId" + "\\}", apiClient.escapeString(corpusId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "timeframe", timeframe));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<Usage> localVarReturnType = new GenericType<Usage>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * User usage
   * Return the aggregated usage report for a single user within the caller&#39;s organization, as headline totals and as a per-bucket time series.  Scope: - **tokens** sums &#x60;post.token&#x60; of sessions where &#x60;session.user_id &#x3D; userId&#x60; AND &#x60;document.token&#x60; of documents where &#x60;document.user_id &#x3D; userId&#x60;, both restricted to corpora of the caller&#39;s organization. - **sessions** counts distinct sessions owned by &#x60;userId&#x60; in the organization. - **posts** counts posts in those sessions. - **storage** sums &#x60;document.size&#x60; of documents uploaded by &#x60;userId&#x60; in the organization. - **corpora** is &#x60;null&#x60; — cardinality is not meaningful at user scope. It is absent from the &#x60;series&#x60; entries too.  Soft-deleted rows count toward lifetime totals; the &#x60;removed&#x60; deltas detect cleanup.  &#x60;timeframe&#x60; selects the **bucket size**, and with it how far back the report reaches:  | &#x60;timeframe&#x60; | bucket    | buckets | history      | |-------------|-----------|---------|--------------| | &#x60;Day&#x60;       | one day   | 30      | ~1 month     | | &#x60;Week&#x60;      | ISO week  | 12      | ~3 months    | | &#x60;Month&#x60;     | one month | 12      | 1 year       | | &#x60;Year&#x60;      | one year  | 5       | 5 years      |  Buckets are aligned to **UTC calendar boundaries** — midnight, Monday, the 1st of the month, the 1st of January — not measured backwards from the current instant, so two calls minutes apart return the same boundaries and two reports line up on a chart.  The report covers **completed buckets only**: the bucket in progress (today, this week, this month, this year) is left out, so &#x60;to&#x60; is the instant that bucket starts at and is never in the future, while &#x60;timestamp&#x60; is the real server time the report was computed at and is later than &#x60;to&#x60;. Activity from the current bucket counts toward the lifetime &#x60;total&#x60;s, but reaches &#x60;created&#x60;, &#x60;removed&#x60;, &#x60;inPeriod&#x60; and &#x60;series&#x60; only once that bucket closes.  &#x60;series&#x60; is contiguous and gapless — a bucket in which nothing happened is present with zeros rather than omitted — and its entries sum exactly to the top-level &#x60;created&#x60;, &#x60;removed&#x60; and &#x60;inPeriod&#x60;. Every window is half-open: &#x60;from&#x60; inclusive, &#x60;to&#x60; exclusive. 
   * @param userId ID of the user to compute usage for. Free-form string (max 256 chars), matched against &#x60;session.user_id&#x60; and &#x60;document.user_id&#x60;. (required)
   * @param timeframe Bucket size to aggregate by, and with it how far back the report reaches. Defaults to &#x60;Day&#x60; (30 daily buckets). (optional)
   * @return a {@code Usage}
   * @throws ApiException if fails to make API call
   */
  public Usage usageByUser(@javax.annotation.Nonnull String userId, @javax.annotation.Nullable String timeframe) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling usageByUser");
    }
    
    // create path and map variables
    String localVarPath = "/v1/usage/user/{userId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "timeframe", timeframe));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "JWT", "AccessToken" };

    GenericType<Usage> localVarReturnType = new GenericType<Usage>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
