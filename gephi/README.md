# Setup and running

- Clone Gephi [v0.9.6](https://github.com/gephi/gephi/tree/v0.9.6)
- `cd /path/to/gephi/modules/application/` 
- To enable Glowroot, modify `default_options` in `/path/to/gephi/modules/application/target/gephi.conf`
  - `default_options="--branding ${branding.token} -J-javaagent:/path/to/glowroot/glowroot.jar -J-Dsun.java2d.metal=true -J-Dsun.java2d.noddraw=true -J-Dsun.awt.noerasebackground=true -J-Dapple.awt.graphics.UseQuartz=true -J-Dnetbeans.indexing.noFileRefresh=true -J-Dplugin.manager.check.interval=EVERY_DAY -J--add-opens=java.base/java.net=ALL-UNNAMED -J--add-exports=java.desktop/sun.awt=ALL-UNNAMED -J--add-opens=java.desktop/javax.swing=ALL-UNNAMED -J--add-opens=java.base/java.nio=ALL-UNNAMED -J--add-exports=java.desktop/sun.awt=ALL-UNNAMED"`
- Run with `mvn nbm:cluster-app nbm:run-platform`
