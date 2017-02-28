/*
 * Copyright (c) 2017 GreenLock Advisory. All Rights Reserved.
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met: Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.vmware.burp.extension.domain;

//import burp.IHttpRequestResponse;
import burp.IScanIssue;
import burp.IScanQueueItem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanQueueItem {

   @XmlElement(required = true)
   private String status;

   @XmlElement(required = true)
   private byte percentageComplete;

   @XmlElement(required = true)
   private int numRequests;

   @XmlElement(required = true)
   private int numErrors;

   @XmlElement(required = true)
   private int numInsertionPoints;

   @XmlElement(required = true)
   private ScanIssueList scanIssueList;

   //@XmlElement(required = true)
   //private List<ScanQueueItem> scanQueueItems;

   //@XmlElement(required = true)
   //List<IScanQueueItem> scanQueueItems;

   private ScanQueueItem() {
   }

   /*public ScanQueueUrl(String url, List<IScanQueueItem> scanQueueItems) {
      this.url = new URL(url);
      this.scanQueueItems = scanQueueItems;
   }*/
   public ScanQueueItem(IScanQueueItem iScanQueueItem) {
     this.status = iScanQueueItem.getStatus();
     this.percentageComplete = iScanQueueItem.getPercentageComplete();
     this.numRequests = iScanQueueItem.getNumRequests();
     this.numErrors = iScanQueueItem.getNumErrors();
     this.numInsertionPoints = iScanQueueItem.getNumInsertionPoints();
     //this.scanIssueList = new ScanIssueList(iScanQueueItem.getIssues());

     List<ScanIssue> scanIssues = new ArrayList<>();
     IScanIssue[] iScanIssues = iScanQueueItem.getIssues();
     for (IScanIssue iScanIssue : iScanIssues) {
        scanIssues.add(new ScanIssue(iScanIssue));
     }
     this.scanIssueList = new ScanIssueList(scanIssues);
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public byte getPercentageComplete() {
      return percentageComplete;
   }

   public void setPercentageComplete(byte percentageComplete) {
      this.percentageComplete = percentageComplete;
   }

   public int getNumRequests() {
      return numRequests;
   }

   public void setNumRequests(int numRequests) {
      this.numRequests = numRequests;
   }

   public int getNumErrors() {
      return numErrors;
   }

   public void setNumErrors(int numErrors) {
      this.numErrors = numErrors;
   }

   public int getNumInsertionPoints() {
      return numInsertionPoints;
   }

   public void setNumInsertionPoints(int numInsertionPoints) {
      this.numInsertionPoints = numInsertionPoints;
   }

   public ScanIssueList getScanIssueList() {
      return scanIssueList;
   }

   public void setScanIssueList(ScanIssueList scanIssueList) {
      this.scanIssueList = scanIssueList;
   }

}
