package com.chrisrm.idea.utils;

import com.intellij.util.ui.JBUI;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MTUiUtils {
  public static final int PADDING = 4;
  public static final int HEIGHT = 16;
  public static final String MATERIAL_FONT = "Roboto";
  public static RenderingHints HINTS;

  static {
    MTUiUtils.HINTS = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION,
        RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
    MTUiUtils.HINTS.put(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    MTUiUtils.HINTS.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_SPEED);
    MTUiUtils.HINTS.put(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    MTUiUtils.HINTS.put(RenderingHints.KEY_FRACTIONALMETRICS,
        RenderingHints.VALUE_FRACTIONALMETRICS_ON);
  }

  public static Font findFont(String name) {
    for (Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
      if (font.getFamily().equals(name)) {
        return font;
      }
    }
    return null;
  }


  public static Font getWidgetFont() {
    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = e.getAllFonts();
    for (Font f : fonts) {
      if (Objects.equals(f.getFontName(), MATERIAL_FONT)) {

        Map<TextAttribute, Object> attributes = new HashMap<>();

        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_ULTRABOLD);
        attributes.put(TextAttribute.SIZE, 8);

        return f.deriveFont(attributes);

      }
    }
    return JBUI.Fonts.label(12);
  }
}
