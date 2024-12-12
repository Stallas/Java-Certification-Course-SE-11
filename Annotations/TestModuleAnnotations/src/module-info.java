import annotations.ModuleAnnotation;
// we actually get compiler error so add target whose element type is module in ModuleAnnotation.java
@Deprecated // Adding this will cause warnings in its TestDeprecatedModule module
@ModuleAnnotation
module TestModuleAnnotations {
    exports test;
}