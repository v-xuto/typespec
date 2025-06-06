// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package azure.core.page.generated;

// The Java test files under 'generated' package are generated for your reference.
// If you wish to modify these files, please copy them out of the 'generated' package, and modify there.
// See https://aka.ms/azsdk/dpg/java/tests for guide on adding a test.

import azure.core.page.PageClient;
import azure.core.page.PageClientBuilder;
import azure.core.page.TwoModelsAsPageItemClient;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.test.TestMode;
import com.azure.core.test.TestProxyTestBase;
import com.azure.core.util.Configuration;

class PageClientTestBase extends TestProxyTestBase {
    protected PageClient pageClient;

    protected TwoModelsAsPageItemClient twoModelsAsPageItemClient;

    @Override
    protected void beforeTest() {
        PageClientBuilder pageClientbuilder = new PageClientBuilder()
            .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT", "http://localhost:3000"))
            .httpClient(getHttpClientOrUsePlayback(getHttpClients().findFirst().orElse(null)))
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BASIC));
        if (getTestMode() == TestMode.RECORD) {
            pageClientbuilder.addPolicy(interceptorManager.getRecordPolicy());
        }
        pageClient = pageClientbuilder.buildClient();

        PageClientBuilder twoModelsAsPageItemClientbuilder = new PageClientBuilder()
            .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT", "http://localhost:3000"))
            .httpClient(getHttpClientOrUsePlayback(getHttpClients().findFirst().orElse(null)))
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BASIC));
        if (getTestMode() == TestMode.RECORD) {
            twoModelsAsPageItemClientbuilder.addPolicy(interceptorManager.getRecordPolicy());
        }
        twoModelsAsPageItemClient = twoModelsAsPageItemClientbuilder.buildTwoModelsAsPageItemClient();

    }
}
