package com.lwp.lint;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.psi.PsiMethod;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.uast.UCallExpression;

import java.util.Arrays;
import java.util.List;

/**
 * Detector: 就是对违反我们规则的“检查”。Detector当lint扫描项目时，将调用其中的方法
 *
 */
public class LogDetector extends Detector implements Detector.UastScanner {

    /**
     * 这是Issue我们正在尝试检查的问题
     */
    public static final Issue ISSUE = Issue.create(
            "LogUsage",
            "避免调用android.util.Log",
            "请勿直接调用android.util.Log，应该使用统一工具类",
            Category.SECURITY, 5, Severity.ERROR,
            new Implementation(LogDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public List<String> getApplicableMethodNames() {
        System.out.println("==== getApplicableMethodNames ====");
        return Arrays.asList("tag", "format", "v", "d", "i", "w", "e", "wtf");
    }

    @Override
    public void visitMethod(@NotNull JavaContext context, @NotNull UCallExpression call, @NotNull PsiMethod method) {
        System.out.println("==== visitMethod old ====");
        if (context.getEvaluator().isMemberInClass(method,"android.util.Log")){
            context.report(ISSUE,call,context.getLocation(call),
                    "请勿直接调用android.util.Log，应该使用统一工具类");
        }
    }



    // 没有调用该方法
//    @Override
//    public void visitMethod(@NotNull JavaContext context, @Nullable JavaElementVisitor visitor,
//                            @NotNull PsiMethodCallExpression call, @NotNull PsiMethod method) {
//
//        System.out.println("==== visitMethod new  ====");
//        super.visitMethod(context, visitor, call, method);
//    }
}
