# RICK workload for GraphHopper

Running
- Download `sweden-latest.osm.pbf` from [this page](https://download.geofabrik.de/europe/sweden.html)
- Running the server: `java -Ddw.graphhopper.datareader.file=sweden-latest.osm.pbf -jar graphhopper-web-5.3.jar server config.yml`
- The first time you run Graphhopper, it takes a long time for the server to be up because graphhopper builds a cache
- Subsequent runs are faster
- We've disabled logs, so it seems like not much is going on, but graphhopper is building the `graph-cache` directory
- The server is finally ready when you get a message that ends in "... HealthCheckRegistry will be ignored."
- The UI can be accessed at [localhost:8989](http://localhost:8989)
  - [bike route](http://localhost:8989/maps/?point=Kungsgatan%2C%20Uppsala&point=Virebergsv%C3%A4gen%2C%20Stockholm&point=Gr%C3%B6ndalsv%C3%A4gen%2C%20Stockholm&point=Kungliga%20Tekniska%20H%C3%B6gskolan%2C%20Stockholm&locale=en-US&elevation=true&profile=bike&use_miles=false&selected_detail=Elevation&layer=OpenStreetMap.de)
  - [car route](http://localhost:8989/maps/?point=Kungsgatan%2C%20Uppsala&point=Virebergsv%C3%A4gen%2C%20Stockholm&point=Gr%C3%B6ndalsv%C3%A4gen%2C%20Stockholm&point=Kungliga%20Tekniska%20H%C3%B6gskolan%2C%20Stockholm&locale=en-US&elevation=true&profile=car&use_miles=false&selected_detail=Elevation&layer=OpenStreetMap.de)

#### [Data](https://kth-my.sharepoint.com/:f:/g/personal/deepikat_ug_kth_se/EibMuFW-rJNJkEWJVazgfK4BOFaWgGiJKAfFV2mGXw-4tQ?e=J4sdcm)
