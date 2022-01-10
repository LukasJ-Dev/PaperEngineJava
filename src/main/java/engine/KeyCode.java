package engine;

public class KeyCode {
    /*
    Stolen from GLFW.java
     */
    public static final int
            PAPER_KEY_SPACE         = 32,
            PAPER_KEY_APOSTROPHE    = 39,
            PAPER_KEY_COMMA         = 44,
            PAPER_KEY_MINUS         = 45,
            PAPER_KEY_PERIOD        = 46,
            PAPER_KEY_SLASH         = 47,
            PAPER_KEY_0             = 48,
            PAPER_KEY_1             = 49,
            PAPER_KEY_2             = 50,
            PAPER_KEY_3             = 51,
            PAPER_KEY_4             = 52,
            PAPER_KEY_5             = 53,
            PAPER_KEY_6             = 54,
            PAPER_KEY_7             = 55,
            PAPER_KEY_8             = 56,
            PAPER_KEY_9             = 57,
            PAPER_KEY_SEMICOLON     = 59,
            PAPER_KEY_EQUAL         = 61,
            PAPER_KEY_A             = 65,
            PAPER_KEY_B             = 66,
            PAPER_KEY_C             = 67,
            PAPER_KEY_D             = 68,
            PAPER_KEY_E             = 69,
            PAPER_KEY_F             = 70,
            PAPER_KEY_G             = 71,
            PAPER_KEY_H             = 72,
            PAPER_KEY_I             = 73,
            PAPER_KEY_J             = 74,
            PAPER_KEY_K             = 75,
            PAPER_KEY_L             = 76,
            PAPER_KEY_M             = 77,
            PAPER_KEY_N             = 78,
            PAPER_KEY_O             = 79,
            PAPER_KEY_P             = 80,
            PAPER_KEY_Q             = 81,
            PAPER_KEY_R             = 82,
            PAPER_KEY_S             = 83,
            PAPER_KEY_T             = 84,
            PAPER_KEY_U             = 85,
            PAPER_KEY_V             = 86,
            PAPER_KEY_W             = 87,
            PAPER_KEY_X             = 88,
            PAPER_KEY_Y             = 89,
            PAPER_KEY_Z             = 90,
            PAPER_KEY_LEFT_BRACKET  = 91,
            PAPER_KEY_BACKSLASH     = 92,
            PAPER_KEY_RIGHT_BRACKET = 93,
            PAPER_KEY_GRAVE_ACCENT  = 96,
            PAPER_KEY_WORLD_1       = 161,
            PAPER_KEY_WORLD_2       = 162;

    /** Function keys. */
    public static final int
            PAPER_KEY_ESCAPE        = 256,
            PAPER_KEY_ENTER         = 257,
            PAPER_KEY_TAB           = 258,
            PAPER_KEY_BACKSPACE     = 259,
            PAPER_KEY_INSERT        = 260,
            PAPER_KEY_DELETE        = 261,
            PAPER_KEY_RIGHT         = 262,
            PAPER_KEY_LEFT          = 263,
            PAPER_KEY_DOWN          = 264,
            PAPER_KEY_UP            = 265,
            PAPER_KEY_PAGE_UP       = 266,
            PAPER_KEY_PAGE_DOWN     = 267,
            PAPER_KEY_HOME          = 268,
            PAPER_KEY_END           = 269,
            PAPER_KEY_CAPS_LOCK     = 280,
            PAPER_KEY_SCROLL_LOCK   = 281,
            PAPER_KEY_NUM_LOCK      = 282,
            PAPER_KEY_PRINT_SCREEN  = 283,
            PAPER_KEY_PAUSE         = 284,
            PAPER_KEY_F1            = 290,
            PAPER_KEY_F2            = 291,
            PAPER_KEY_F3            = 292,
            PAPER_KEY_F4            = 293,
            PAPER_KEY_F5            = 294,
            PAPER_KEY_F6            = 295,
            PAPER_KEY_F7            = 296,
            PAPER_KEY_F8            = 297,
            PAPER_KEY_F9            = 298,
            PAPER_KEY_F10           = 299,
            PAPER_KEY_F11           = 300,
            PAPER_KEY_F12           = 301,
            PAPER_KEY_F13           = 302,
            PAPER_KEY_F14           = 303,
            PAPER_KEY_F15           = 304,
            PAPER_KEY_F16           = 305,
            PAPER_KEY_F17           = 306,
            PAPER_KEY_F18           = 307,
            PAPER_KEY_F19           = 308,
            PAPER_KEY_F20           = 309,
            PAPER_KEY_F21           = 310,
            PAPER_KEY_F22           = 311,
            PAPER_KEY_F23           = 312,
            PAPER_KEY_F24           = 313,
            PAPER_KEY_F25           = 314,
            PAPER_KEY_KP_0          = 320,
            PAPER_KEY_KP_1          = 321,
            PAPER_KEY_KP_2          = 322,
            PAPER_KEY_KP_3          = 323,
            PAPER_KEY_KP_4          = 324,
            PAPER_KEY_KP_5          = 325,
            PAPER_KEY_KP_6          = 326,
            PAPER_KEY_KP_7          = 327,
            PAPER_KEY_KP_8          = 328,
            PAPER_KEY_KP_9          = 329,
            PAPER_KEY_KP_DECIMAL    = 330,
            PAPER_KEY_KP_DIVIDE     = 331,
            PAPER_KEY_KP_MULTIPLY   = 332,
            PAPER_KEY_KP_SUBTRACT   = 333,
            PAPER_KEY_KP_ADD        = 334,
            PAPER_KEY_KP_ENTER      = 335,
            PAPER_KEY_KP_EQUAL      = 336,
            PAPER_KEY_LEFT_SHIFT    = 340,
            PAPER_KEY_LEFT_CONTROL  = 341,
            PAPER_KEY_LEFT_ALT      = 342,
            PAPER_KEY_LEFT_SUPER    = 343,
            PAPER_KEY_RIGHT_SHIFT   = 344,
            PAPER_KEY_RIGHT_CONTROL = 345,
            PAPER_KEY_RIGHT_ALT     = 346,
            PAPER_KEY_RIGHT_SUPER   = 347,
            PAPER_KEY_MENU          = 348,
            PAPER_KEY_LAST          = PAPER_KEY_MENU;

    /** If this bit is set one or more Shift keys were held down. */
    public static final int PAPER_MOD_SHIFT = 0x1;

    /** If this bit is set one or more Control keys were held down. */
    public static final int PAPER_MOD_CONTROL = 0x2;

    /** If this bit is set one or more Alt keys were held down. */
    public static final int PAPER_MOD_ALT = 0x4;

    /** If this bit is set one or more Super keys were held down. */
    public static final int PAPER_MOD_SUPER = 0x8;

    /** If this bit is set the Caps Lock key is enabled and the {@link #GLFW_LOCK_KEY_MODS LOCK_KEY_MODS} input mode is set. */
    public static final int PAPER_MOD_CAPS_LOCK = 0x10;

    /** If this bit is set the Num Lock key is enabled and the {@link #GLFW_LOCK_KEY_MODS LOCK_KEY_MODS} input mode is set. */
    public static final int PAPER_MOD_NUM_LOCK = 0x20;

    /** Mouse buttons. See <a target="_blank" href="http://www.glfw.org/docs/latest/input.html#input_mouse_button">mouse button input</a> for how these are used. */
    public static final int
            PAPER_MOUSE_BUTTON_1      = 0,
            PAPER_MOUSE_BUTTON_2      = 1,
            PAPER_MOUSE_BUTTON_3      = 2,
            PAPER_MOUSE_BUTTON_4      = 3,
            PAPER_MOUSE_BUTTON_5      = 4,
            PAPER_MOUSE_BUTTON_6      = 5,
            PAPER_MOUSE_BUTTON_7      = 6,
            PAPER_MOUSE_BUTTON_8      = 7,
            PAPER_MOUSE_BUTTON_LAST   = PAPER_MOUSE_BUTTON_8,
            PAPER_MOUSE_BUTTON_LEFT   = PAPER_MOUSE_BUTTON_1,
            PAPER_MOUSE_BUTTON_RIGHT  = PAPER_MOUSE_BUTTON_2,
            PAPER_MOUSE_BUTTON_MIDDLE = PAPER_MOUSE_BUTTON_3;

    /** Joysticks. See <a target="_blank" href="http://www.glfw.org/docs/latest/input.html#joystick">joystick input</a> for how these are used. */
    public static final int
            PAPER_JOYSTICK_1    = 0,
            PAPER_JOYSTICK_2    = 1,
            PAPER_JOYSTICK_3    = 2,
            PAPER_JOYSTICK_4    = 3,
            PAPER_JOYSTICK_5    = 4,
            PAPER_JOYSTICK_6    = 5,
            PAPER_JOYSTICK_7    = 6,
            PAPER_JOYSTICK_8    = 7,
            PAPER_JOYSTICK_9    = 8,
            PAPER_JOYSTICK_10   = 9,
            PAPER_JOYSTICK_11   = 10,
            PAPER_JOYSTICK_12   = 11,
            PAPER_JOYSTICK_13   = 12,
            PAPER_JOYSTICK_14   = 13,
            PAPER_JOYSTICK_15   = 14,
            PAPER_JOYSTICK_16   = 15,
            PAPER_JOYSTICK_LAST = PAPER_JOYSTICK_16;

    /** Gamepad buttons. See <a target="_blank" href="http://www.glfw.org/docs/latest/input.html#gamepad">gamepad</a> for how these are used. */
    public static final int
            PAPER_GAMEPAD_BUTTON_A            = 0,
            PAPER_GAMEPAD_BUTTON_B            = 1,
            PAPER_GAMEPAD_BUTTON_X            = 2,
            PAPER_GAMEPAD_BUTTON_Y            = 3,
            PAPER_GAMEPAD_BUTTON_LEFT_BUMPER  = 4,
            PAPER_GAMEPAD_BUTTON_RIGHT_BUMPER = 5,
            PAPER_GAMEPAD_BUTTON_BACK         = 6,
            PAPER_GAMEPAD_BUTTON_START        = 7,
            PAPER_GAMEPAD_BUTTON_GUIDE        = 8,
            PAPER_GAMEPAD_BUTTON_LEFT_THUMB   = 9,
            PAPER_GAMEPAD_BUTTON_RIGHT_THUMB  = 10,
            PAPER_GAMEPAD_BUTTON_DPAD_UP      = 11,
            PAPER_GAMEPAD_BUTTON_DPAD_RIGHT   = 12,
            PAPER_GAMEPAD_BUTTON_DPAD_DOWN    = 13,
            PAPER_GAMEPAD_BUTTON_DPAD_LEFT    = 14,
            PAPER_GAMEPAD_BUTTON_LAST         = PAPER_GAMEPAD_BUTTON_DPAD_LEFT,
            PAPER_GAMEPAD_BUTTON_CROSS        = PAPER_GAMEPAD_BUTTON_A,
            PAPER_GAMEPAD_BUTTON_CIRCLE       = PAPER_GAMEPAD_BUTTON_B,
            PAPER_GAMEPAD_BUTTON_SQUARE       = PAPER_GAMEPAD_BUTTON_X,
            PAPER_GAMEPAD_BUTTON_TRIANGLE     = PAPER_GAMEPAD_BUTTON_Y;

    /** Gamepad axes. See <a target="_blank" href="http://www.glfw.org/docs/latest/input.html#gamepad">gamepad</a> for how these are used. */
    public static final int
            PAPER_GAMEPAD_AXIS_LEFT_X        = 0,
            PAPER_GAMEPAD_AXIS_LEFT_Y        = 1,
            PAPER_GAMEPAD_AXIS_RIGHT_X       = 2,
            PAPER_GAMEPAD_AXIS_RIGHT_Y       = 3,
            PAPER_GAMEPAD_AXIS_LEFT_TRIGGER  = 4,
            PAPER_GAMEPAD_AXIS_RIGHT_TRIGGER = 5,
            PAPER_GAMEPAD_AXIS_LAST          = PAPER_GAMEPAD_AXIS_RIGHT_TRIGGER;
}
