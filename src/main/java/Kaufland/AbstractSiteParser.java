package Kaufland;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractSiteParser implements SiteParser{
 protected String shopname;
 protected String html;
 protected Map<String,String> alternativeLanguageUrls = new HashMap<>();

}
