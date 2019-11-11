package java8.functionalinterface;

// @FunctionalInterface is used only to check if the interface satisfies the contract for functional interface
@FunctionalInterface
public interface Converter<From,To> {
	To convert(From f);
}
