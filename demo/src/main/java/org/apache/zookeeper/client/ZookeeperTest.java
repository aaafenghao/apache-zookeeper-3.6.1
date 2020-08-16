package org.apache.zookeeper.client;

import org.apache.zookeeper.*;

import java.io.IOException;


public class ZookeeperTest {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("------");
            }
        });
        zooKeeper.create("/fh","fenghao".getBytes(),null, null);
    }
}
