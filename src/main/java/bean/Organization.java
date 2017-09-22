package bean;

/**
 * 组织
 *
 * @author zhan
 * Created on 2017/09/22  18:45
 */
public class Organization {
    private String id;
    private String description;
    private boolean isValide;
    private Actor creator;
    private Image image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValide() {
        return isValide;
    }

    public void setValide(boolean valide) {
        isValide = valide;
    }

    public Actor getCreator() {
        return creator;
    }

    public void setCreator(Actor creator) {
        this.creator = creator;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
