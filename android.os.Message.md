#1、Message代码结构
![Message代码结构](https://raw.githubusercontent.com/chaozhouzhang/SourceCodeAnalysis/master/pic/android.os.Message.png)
##1.2、属性
```
    /*package*/ int flags;//Getter/Setter

    /*package*/ long when;//只有Getter没有Setter
    
    /*package*/ Bundle data;//Getter/Setter
    
    /*package*/ Handler target;//Getter/Setter
    
    /*package*/ Runnable callback;//只有Getter没有Setter
```
###flags
```
/** If set message is in use.
 * This flag is set when the message is enqueued and remains set while it
 * is delivered and afterwards when it is recycled.  The flag is only cleared
 * when a new message is created or obtained since that is the only time that
 * applications are allowed to modify the contents of the message.
 *
 * It is an error to attempt to enqueue or recycle a message that is already in use.
 */
/*package*/ static final int FLAG_IN_USE = 1 << 0;

/** If set message is asynchronous */
/*package*/ static final int FLAG_ASYNCHRONOUS = 1 << 1;

/** Flags to clear in the copyFrom method */
/*package*/ static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAG_IN_USE;


```

###



