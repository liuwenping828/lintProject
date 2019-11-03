package com.lwp.lint;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static com.android.tools.lint.detector.api.ApiKt.CURRENT_API;

/**
 * IssueRegistry：此类为lint提供了Issue我们要扫描项目的 Issue
 */
public class MyIssueRegistry extends IssueRegistry {

    @NotNull
    @Override
    public List<Issue> getIssues() {
        System.out.println("==== my lint start ====");
        return Arrays.asList(LogDetector.ISSUE, NewThreadDetector.ISSUE);
    }

    @Override
    public int getApi() {
        return CURRENT_API;
    }
}
