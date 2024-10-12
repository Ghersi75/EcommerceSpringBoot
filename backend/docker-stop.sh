#!/bin/bash

# A script to stop docker and optionally remove volumes
delete_volumes=false

# Check for the --delete-volumes flag
for arg in "$@"
do
    if [[ "$arg" == "--delete-volumes" ]]; then
        delete_volumes=true
    fi
done

if [ "$delete_volumes" = true ] ; then
    echo "Stopping Docker Compose and removing volumes..."
    docker compose down --volumes
else
    echo "Stopping Docker Compose without removing volumes..."
    docker compose down
fi
