public class Node {

    private Object data;
    private Object point;
    private Node link;

    public Node(Object dataToAdd) {
        data= dataToAdd;
        link=null;
    }

    public Node(Object data, Object point) {
        this.data = data;
        this.point = point;
        link = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Object getPoint() {
        return point;
    }

    public void setPoint(Object point) {
        this.point = point;
    }
}
