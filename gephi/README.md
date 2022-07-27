# RICK workload for Gephi

Setup and running:
- Clone Gephi [v0.9.6](https://github.com/gephi/gephi/tree/v0.9.6)
- `cd /path/to/gephi/modules/application/` 
- To enable Glowroot, modify `default_options` in `/path/to/gephi/modules/application/target/gephi.conf`
  - `default_options="--branding ${branding.token} -J-javaagent:/path/to/glowroot/glowroot.jar -J-Dsun.java2d.metal=true -J-Dsun.java2d.noddraw=true -J-Dsun.awt.noerasebackground=true -J-Dapple.awt.graphics.UseQuartz=true -J-Dnetbeans.indexing.noFileRefresh=true -J-Dplugin.manager.check.interval=EVERY_DAY -J--add-opens=java.base/java.net=ALL-UNNAMED -J--add-exports=java.desktop/sun.awt=ALL-UNNAMED -J--add-opens=java.desktop/javax.swing=ALL-UNNAMED -J--add-opens=java.base/java.nio=ALL-UNNAMED -J--add-exports=java.desktop/sun.awt=ALL-UNNAMED"`
- Run with `mvn nbm:cluster-app nbm:run-platform`
- From the Welcome window, choose "Open Graph File", select the `deps_graph_999.gexf` file, click on "OK" in the Import report window
- Under the **Overview** tab,
  - Run the statistics features from the statistics pane on the right
  - From the appearance pane on the top left, change the size and colours of the nodes and edges in the graph
  - Choose different layouts for the graph, from the available layouts on the bottom left
  - Modify edge labels from the options on the bottom pane
- Under the **Data Laboratory** tab,
  - Add, remove, merge nodes, columns
  - Add and remove edges
  - Find and replace nodes
- Under the **Preview** tab,
  - Refresh to generate preview after each change
  - Choose between different presets
  - Enable/disable features
  - Export as SVG, PDF, PNG 
