/*
 * Copyright (c) 2017 GreenLock Advisory. All Rights Reserved.
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met: Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.vmware.burp.extension.domain;

//import burp.IHttpRequestResponse;
//import burp.IScanIssue;
import burp.IScanQueueItem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanQueueUrl {

   @XmlElement(required = true)
   private URL url;

   @XmlElement(required = true)
   List<IScanQueueItem> scanQueueItems;

   private ScanQueueUrl() {
   }

   public ScanQueueUrl(String url, List<IScanQueueItem> scanQueueItems) {
     try {
        this.url = new URL(url);
     }catch(MalformedURLException e){ //nothing
     }
      this.scanQueueItems = scanQueueItems;
   }
   /*public ScanQueueUrl(String url) {
     try {
       this.url = new URL(url);
     }catch(MalformedURLException e){
       //nothing
     }
   }*/

   public URL getUrl() {
      return url;
   }

   public void setUrl(URL url) {
      this.url = url;
   }

   public List<IScanQueueItem> getScanQueueItems() {
      return scanQueueItems;
   }

   public void setScanQueueItems(List<IScanQueueItem> scanQueueItems) {
      this.scanQueueItems = scanQueueItems;
   }


}
