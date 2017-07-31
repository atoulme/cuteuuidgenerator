require 'lock_jar/buildr'
require 'buildr/kotlin'

repositories.remote << "http://repo.maven.apache.org/maven2/"
lock_jar do
       jar "org.springframework.boot:spring-boot-starter-web:jar:1.5.5.RELEASE"
       jar 'org.springframework.boot:spring-boot-loader:jar:1.5.5.RELEASE'
       jar 'org.jetbrains.kotlin:kotlin-runtime:jar:1.1.3-2'
       jar 'org.jetbrains.kotlin:kotlin-stdlib:jar:1.1.3-2'
end

define "cuteuuidgenerator", :group => "io.tmio", :version => "1.0.0" do
  compile.using(:kotlinc)
  package(:jar).with(:manifest => {'Start-Class' => 'io.tmio.uuigen.MainKt',
                                   'Main-Class' => 'org.springframework.boot.loader.JarLauncher'
  }).merge(lock_jars).aggregate('META-INF/spring.factories')
end