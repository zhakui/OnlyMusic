/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\android\\workspace\\OnlyMusic\\src\\com\\zhakui\\OnlyMusic\\service\\IMusicManagerAIDL.aidl
 */
package com.zhakui.OnlyMusic.service;
public interface IMusicManagerAIDL extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.zhakui.OnlyMusic.service.IMusicManagerAIDL
{
private static final java.lang.String DESCRIPTOR = "com.zhakui.OnlyMusic.service.IMusicManagerAIDL";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.zhakui.OnlyMusic.service.IMusicManagerAIDL interface,
 * generating a proxy if needed.
 */
public static com.zhakui.OnlyMusic.service.IMusicManagerAIDL asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.zhakui.OnlyMusic.service.IMusicManagerAIDL))) {
return ((com.zhakui.OnlyMusic.service.IMusicManagerAIDL)iin);
}
return new com.zhakui.OnlyMusic.service.IMusicManagerAIDL.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_play:
{
data.enforceInterface(DESCRIPTOR);
this.play();
reply.writeNoException();
return true;
}
case TRANSACTION_reset:
{
data.enforceInterface(DESCRIPTOR);
this.reset();
reply.writeNoException();
return true;
}
case TRANSACTION_stop:
{
data.enforceInterface(DESCRIPTOR);
this.stop();
reply.writeNoException();
return true;
}
case TRANSACTION_pause:
{
data.enforceInterface(DESCRIPTOR);
this.pause();
reply.writeNoException();
return true;
}
case TRANSACTION_Prev:
{
data.enforceInterface(DESCRIPTOR);
this.Prev();
reply.writeNoException();
return true;
}
case TRANSACTION_next:
{
data.enforceInterface(DESCRIPTOR);
this.next();
reply.writeNoException();
return true;
}
case TRANSACTION_isPlaying:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isPlaying();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isPause:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isPause();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_forward:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.forward(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_rewind:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.rewind(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPlayingSong:
{
data.enforceInterface(DESCRIPTOR);
com.zhakui.OnlyMusic.data.Song _result = this.getPlayingSong();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPlayingSongIndex:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPlayingSongIndex();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPlayingSong:
{
data.enforceInterface(DESCRIPTOR);
com.zhakui.OnlyMusic.data.Song _arg0;
if ((0!=data.readInt())) {
_arg0 = com.zhakui.OnlyMusic.data.Song.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setPlayingSong(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setMediaPathList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.zhakui.OnlyMusic.data.Song> _arg0;
_arg0 = data.createTypedArrayList(com.zhakui.OnlyMusic.data.Song.CREATOR);
this.setMediaPathList(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getCurrentTime:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCurrentTime();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getCurrentPosition:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCurrentPosition();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setPlayMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setPlayMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPlayMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPlayMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_addMediaPathList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.zhakui.OnlyMusic.data.Song> _arg0;
_arg0 = data.createTypedArrayList(com.zhakui.OnlyMusic.data.Song.CREATOR);
this.addMediaPathList(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeMediaPath:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.removeMediaPath(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_addMediaPath:
{
data.enforceInterface(DESCRIPTOR);
com.zhakui.OnlyMusic.data.Song _arg0;
if ((0!=data.readInt())) {
_arg0 = com.zhakui.OnlyMusic.data.Song.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.addMediaPath(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getDurationTime:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDurationTime();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getDuration:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getDuration();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_sendPlayStateBrocast:
{
data.enforceInterface(DESCRIPTOR);
this.sendPlayStateBrocast();
reply.writeNoException();
return true;
}
case TRANSACTION_setSourceType:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setSourceType(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getSourceType:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getSourceType();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_exit:
{
data.enforceInterface(DESCRIPTOR);
this.exit();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.zhakui.OnlyMusic.service.IMusicManagerAIDL
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void play() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_play, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void reset() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_reset, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void stop() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stop, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void pause() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pause, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void Prev() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_Prev, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void next() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_next, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isPlaying() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isPlaying, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isPause() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isPause, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void forward(int time) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(time);
mRemote.transact(Stub.TRANSACTION_forward, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void rewind(int time) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(time);
mRemote.transact(Stub.TRANSACTION_rewind, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public com.zhakui.OnlyMusic.data.Song getPlayingSong() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.zhakui.OnlyMusic.data.Song _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPlayingSong, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.zhakui.OnlyMusic.data.Song.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getPlayingSongIndex() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPlayingSongIndex, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setPlayingSong(com.zhakui.OnlyMusic.data.Song path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((path!=null)) {
_data.writeInt(1);
path.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setPlayingSong, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setMediaPathList(java.util.List<com.zhakui.OnlyMusic.data.Song> pathList) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(pathList);
mRemote.transact(Stub.TRANSACTION_setMediaPathList, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getCurrentTime() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentTime, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getCurrentPosition() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentPosition, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setPlayMode(int playMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(playMode);
mRemote.transact(Stub.TRANSACTION_setPlayMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getPlayMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPlayMode, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void addMediaPathList(java.util.List<com.zhakui.OnlyMusic.data.Song> pathList) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(pathList);
mRemote.transact(Stub.TRANSACTION_addMediaPathList, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeMediaPath(int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_removeMediaPath, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void addMediaPath(com.zhakui.OnlyMusic.data.Song path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((path!=null)) {
_data.writeInt(1);
path.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addMediaPath, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getDurationTime() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDurationTime, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getDuration() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDuration, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void sendPlayStateBrocast() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_sendPlayStateBrocast, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setSourceType(int playMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(playMode);
mRemote.transact(Stub.TRANSACTION_setSourceType, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getSourceType() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSourceType, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void exit() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_exit, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_play = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_reset = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_stop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_pause = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_Prev = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_next = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_isPlaying = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_isPause = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_forward = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_rewind = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_getPlayingSong = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_getPlayingSongIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_setPlayingSong = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_setMediaPathList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_getCurrentTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getCurrentPosition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_setPlayMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_getPlayMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_addMediaPathList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_removeMediaPath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_addMediaPath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_getDurationTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_getDuration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_sendPlayStateBrocast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_setSourceType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_getSourceType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_exit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
}
public void play() throws android.os.RemoteException;
public void reset() throws android.os.RemoteException;
public void stop() throws android.os.RemoteException;
public void pause() throws android.os.RemoteException;
public void Prev() throws android.os.RemoteException;
public void next() throws android.os.RemoteException;
public boolean isPlaying() throws android.os.RemoteException;
public boolean isPause() throws android.os.RemoteException;
public void forward(int time) throws android.os.RemoteException;
public void rewind(int time) throws android.os.RemoteException;
public com.zhakui.OnlyMusic.data.Song getPlayingSong() throws android.os.RemoteException;
public int getPlayingSongIndex() throws android.os.RemoteException;
public void setPlayingSong(com.zhakui.OnlyMusic.data.Song path) throws android.os.RemoteException;
public void setMediaPathList(java.util.List<com.zhakui.OnlyMusic.data.Song> pathList) throws android.os.RemoteException;
public java.lang.String getCurrentTime() throws android.os.RemoteException;
public int getCurrentPosition() throws android.os.RemoteException;
public void setPlayMode(int playMode) throws android.os.RemoteException;
public int getPlayMode() throws android.os.RemoteException;
public void addMediaPathList(java.util.List<com.zhakui.OnlyMusic.data.Song> pathList) throws android.os.RemoteException;
public void removeMediaPath(int index) throws android.os.RemoteException;
public void addMediaPath(com.zhakui.OnlyMusic.data.Song path) throws android.os.RemoteException;
public java.lang.String getDurationTime() throws android.os.RemoteException;
public int getDuration() throws android.os.RemoteException;
public void sendPlayStateBrocast() throws android.os.RemoteException;
public void setSourceType(int playMode) throws android.os.RemoteException;
public int getSourceType() throws android.os.RemoteException;
public void exit() throws android.os.RemoteException;
}
