package core_java;

/**
 * 这些事关于java的核心基础知识的强化。
 * 比如这个类用于学习java的正则表达式。实际问题，比如判断邮箱，电话号码等。该语法中的特殊符号：.,{},[],\,&&,-,D(非数字)
 * backslash(\),反斜线需要转义，
 * 可以由str.match(reg)方法引用，也可以创建正则化对象。同时这个这正则表达式还可以用在split()和replace()方法中。
 */
public class RegularExpression {
    public static void main(String[] args) {
        System.out.println("34300".matches("[\\d]*[02468]"));
        System.out.println("Java Java Java".replaceFirst("v[\\w]","wi"));
        System.out.println("Java1Html2Perl".split("[\\d]",2)); // limit-1 表示匹配的次数。
    }
}
