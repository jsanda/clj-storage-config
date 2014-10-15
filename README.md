# cassandra-yaml-upgrade

This is a small utility that upgrades the Cassandra configuration settings in cassandra.yaml. The newer version of cassandra.yaml is not modified. The program instead writes to a different file leaving the original files intact.

Comments currently are not preserved.

There is a known bug in the current implemenation. If a property that exists in both the old and  new configuration is set in the old but commented out in the new, the value will not be preserved.


## Usage

```
1) lein deps

2) lein uberjar

3) java -jar target/cassandra-yaml-upgrade-0.1.0-SNAPSHOT-standalone.jar <old-cassandra.yaml> <new-cassandra.yaml> <dest-file>
```

## Known Issues
* If a property that exists in both the old and  new configuration is set in the old but commented out in the new, the value will not be preserved.
* Comments currently are not preserved.