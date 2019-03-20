package ca.ualberta.cs.lonelytwitterrefactoring;

import java.io.IOException;
import java.util.Date;

abstract class Tweet {
    protected Date tweetDate;
    protected String tweetBody;

    public Date getDate() {
        return tweetDate;
    }

    public void setDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    public String getBody() {
        return tweetBody;
    }

    public void setBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }

    private void writeObj(java.io.ObjectOutputStream out) throws IOException {
        out.writeObject(tweetDate);
        out.writeObject(tweetBody);
    }

    private void readObj(java.io.ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        tweetDate = (Date) in.readObject();
        tweetBody = (String) in.readObject();
    }

    public abstract boolean validTweet();

    @Override
    public String toString() {
        return getDate() + " | " + getBody() ;
    }
}
