#!/bin/bash

# Check if a container name is provided as an argument
if [ $# -ne 1 ]; then
    echo "Usage: $0 <container_name>"
    exit 1
fi

container_name="$1"

# Check if the container is already running
if docker ps -a --format '{{.Names}}' | grep -Eq "^$container_name$"; then
    # Stop the container
    docker stop "$container_name"

    # Remove the container
    docker rm "$container_name"

    echo "Container $container_name stopped and removed."
else
    echo "Container $container_name is not running."
fi