// File generated by hadoop record compiler. Do not edit.
/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.zookeeper.proto;

import org.apache.jute.*;
import org.apache.yetus.audience.InterfaceAudience;

@InterfaceAudience.Public
public class ConnectRequest implements Record {
  private int protocolVersion;
  private long lastZxidSeen;
  private int timeOut;
  private long sessionId;
  private byte[] passwd;
  public ConnectRequest() {
  }
  public ConnectRequest(
        int protocolVersion,
        long lastZxidSeen,
        int timeOut,
        long sessionId,
        byte[] passwd) {
    this.protocolVersion=protocolVersion;
    this.lastZxidSeen=lastZxidSeen;
    this.timeOut=timeOut;
    this.sessionId=sessionId;
    this.passwd=passwd;
  }
  public int getProtocolVersion() {
    return protocolVersion;
  }
  public void setProtocolVersion(int m_) {
    protocolVersion=m_;
  }
  public long getLastZxidSeen() {
    return lastZxidSeen;
  }
  public void setLastZxidSeen(long m_) {
    lastZxidSeen=m_;
  }
  public int getTimeOut() {
    return timeOut;
  }
  public void setTimeOut(int m_) {
    timeOut=m_;
  }
  public long getSessionId() {
    return sessionId;
  }
  public void setSessionId(long m_) {
    sessionId=m_;
  }
  public byte[] getPasswd() {
    return passwd;
  }
  public void setPasswd(byte[] m_) {
    passwd=m_;
  }
  public void serialize(OutputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(this,tag);
    a_.writeInt(protocolVersion,"protocolVersion");
    a_.writeLong(lastZxidSeen,"lastZxidSeen");
    a_.writeInt(timeOut,"timeOut");
    a_.writeLong(sessionId,"sessionId");
    a_.writeBuffer(passwd,"passwd");
    a_.endRecord(this,tag);
  }
  public void deserialize(InputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(tag);
    protocolVersion=a_.readInt("protocolVersion");
    lastZxidSeen=a_.readLong("lastZxidSeen");
    timeOut=a_.readInt("timeOut");
    sessionId=a_.readLong("sessionId");
    passwd=a_.readBuffer("passwd");
    a_.endRecord(tag);
}
  public String toString() {
    try {
      java.io.ByteArrayOutputStream s =
        new java.io.ByteArrayOutputStream();
      ToStringOutputArchive a_ = 
        new ToStringOutputArchive(s);
      a_.startRecord(this,"");
    a_.writeInt(protocolVersion,"protocolVersion");
    a_.writeLong(lastZxidSeen,"lastZxidSeen");
    a_.writeInt(timeOut,"timeOut");
    a_.writeLong(sessionId,"sessionId");
    a_.writeBuffer(passwd,"passwd");
      a_.endRecord(this,"");
      return new String(s.toByteArray(), "UTF-8");
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
    return "ERROR";
  }
  public void write(java.io.DataOutput out) throws java.io.IOException {
    BinaryOutputArchive archive = new BinaryOutputArchive(out);
    serialize(archive, "");
  }
  public void readFields(java.io.DataInput in) throws java.io.IOException {
    BinaryInputArchive archive = new BinaryInputArchive(in);
    deserialize(archive, "");
  }
  public int compareTo (Object peer_) throws ClassCastException {
    if (!(peer_ instanceof ConnectRequest)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    ConnectRequest peer = (ConnectRequest) peer_;
    int ret = 0;
    ret = (protocolVersion == peer.protocolVersion)? 0 :((protocolVersion<peer.protocolVersion)?-1:1);
    if (ret != 0) return ret;
    ret = (lastZxidSeen == peer.lastZxidSeen)? 0 :((lastZxidSeen<peer.lastZxidSeen)?-1:1);
    if (ret != 0) return ret;
    ret = (timeOut == peer.timeOut)? 0 :((timeOut<peer.timeOut)?-1:1);
    if (ret != 0) return ret;
    ret = (sessionId == peer.sessionId)? 0 :((sessionId<peer.sessionId)?-1:1);
    if (ret != 0) return ret;
    {
      byte[] my = passwd;
      byte[] ur = peer.passwd;
      ret = Utils.compareBytes(my,0,my.length,ur,0,ur.length);
    }
    if (ret != 0) return ret;
     return ret;
  }
  public boolean equals(Object peer_) {
    if (!(peer_ instanceof ConnectRequest)) {
      return false;
    }
    if (peer_ == this) {
      return true;
    }
    ConnectRequest peer = (ConnectRequest) peer_;
    boolean ret = false;
    ret = (protocolVersion==peer.protocolVersion);
    if (!ret) return ret;
    ret = (lastZxidSeen==peer.lastZxidSeen);
    if (!ret) return ret;
    ret = (timeOut==peer.timeOut);
    if (!ret) return ret;
    ret = (sessionId==peer.sessionId);
    if (!ret) return ret;
    ret = Utils.bufEquals(passwd,peer.passwd);
    if (!ret) return ret;
     return ret;
  }
  public int hashCode() {
    int result = 17;
    int ret;
    ret = (int)protocolVersion;
    result = 37*result + ret;
    ret = (int) (lastZxidSeen^(lastZxidSeen>>>32));
    result = 37*result + ret;
    ret = (int)timeOut;
    result = 37*result + ret;
    ret = (int) (sessionId^(sessionId>>>32));
    result = 37*result + ret;
    ret = java.util.Arrays.toString(passwd).hashCode();
    result = 37*result + ret;
    return result;
  }
  public static String signature() {
    return "LConnectRequest(ililB)";
  }
}
