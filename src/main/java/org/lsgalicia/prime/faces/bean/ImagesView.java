package org.lsgalicia.prime.faces.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="ImagesView")
@ViewScoped
public class ImagesView implements Serializable {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 13; i++) {
            images.add("agile" + i + ".jpg");
        }

    }

    public List<String> getImages() {
        return images;
    }

}
