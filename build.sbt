import org.scalajs.linker.interface.OutputPatterns
scalaVersion := "3.1.3"

enablePlugins(ScalaJSPlugin, EsbuildPlugin)

scalaJSUseMainModuleInitializer := true

libraryDependencies += "com.raquo" %%% "laminar" % "0.14.2"

name := "laminar-static"

Compile / npmDependencies ++= Seq(
  "@ui5/webcomponents" -> "1.3.0"
)

resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.sherpal" % "LaminarSAPUI5Bindings" % "1.3.0-7ce0fe34"

scalaJSLinkerConfig ~= { c =>
  c.withModuleKind(ModuleKind.CommonJSModule).withClosureCompiler(true)
}

Global / onChangedBuildSource := ReloadOnSourceChanges

esbuildOptions := Seq("--log-level=debug")
