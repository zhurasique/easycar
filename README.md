Startup instruction:

`sh build.sh prune start skip-tests` where `prune` allows script to remove unused images from Docker, `start` makes docker-compose to start application and `skip-tests` prevents tests invocation. Those parameters are optional.

`sh build_single.sh service-name skip-tests` to rebuild and reload specific container inside docker-compose use `service-name` stands container name (should be named same as service) and `skip-tests` prevents tests invocation (optional).

