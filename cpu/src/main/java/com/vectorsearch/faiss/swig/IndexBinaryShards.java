/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.vectorsearch.faiss.swig;

public class IndexBinaryShards extends ThreadedIndexBaseBinary {
  private transient long swigCPtr;

  protected IndexBinaryShards(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.IndexBinaryShards_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IndexBinaryShards obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IndexBinaryShards(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public IndexBinaryShards(boolean threaded, boolean successive_ids) {
    this(swigfaissJNI.new_IndexBinaryShards__SWIG_0(threaded, successive_ids), true);
  }

  public IndexBinaryShards(boolean threaded) {
    this(swigfaissJNI.new_IndexBinaryShards__SWIG_1(threaded), true);
  }

  public IndexBinaryShards() {
    this(swigfaissJNI.new_IndexBinaryShards__SWIG_2(), true);
  }

  public IndexBinaryShards(int d, boolean threaded, boolean successive_ids) {
    this(swigfaissJNI.new_IndexBinaryShards__SWIG_3(d, threaded, successive_ids), true);
  }

  public IndexBinaryShards(int d, boolean threaded) {
    this(swigfaissJNI.new_IndexBinaryShards__SWIG_4(d, threaded), true);
  }

  public IndexBinaryShards(int d) {
    this(swigfaissJNI.new_IndexBinaryShards__SWIG_5(d), true);
  }

  public void add_shard(IndexBinary index) {
    swigfaissJNI.IndexBinaryShards_add_shard(swigCPtr, this, IndexBinary.getCPtr(index), index);
  }

  public void remove_shard(IndexBinary index) {
    swigfaissJNI.IndexBinaryShards_remove_shard(swigCPtr, this, IndexBinary.getCPtr(index), index);
  }

  public void add(int n, SWIGTYPE_p_unsigned_char x) {
    swigfaissJNI.IndexBinaryShards_add(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x));
  }

  public void add_with_ids(int n, SWIGTYPE_p_unsigned_char x, SWIGTYPE_p_long xids) {
    swigfaissJNI.IndexBinaryShards_add_with_ids(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x), SWIGTYPE_p_long.getCPtr(xids));
  }

  public void search(int n, SWIGTYPE_p_unsigned_char x, int k, SWIGTYPE_p_int distances, SWIGTYPE_p_long labels) {
    swigfaissJNI.IndexBinaryShards_search(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x), k, SWIGTYPE_p_int.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels));
  }

  public void train(int n, SWIGTYPE_p_unsigned_char x) {
    swigfaissJNI.IndexBinaryShards_train(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x));
  }

  public void sync_with_shard_indexes() {
    swigfaissJNI.IndexBinaryShards_sync_with_shard_indexes(swigCPtr, this);
  }

  public void setSuccessive_ids(boolean value) {
    swigfaissJNI.IndexBinaryShards_successive_ids_set(swigCPtr, this, value);
  }

  public boolean getSuccessive_ids() {
    return swigfaissJNI.IndexBinaryShards_successive_ids_get(swigCPtr, this);
  }

}