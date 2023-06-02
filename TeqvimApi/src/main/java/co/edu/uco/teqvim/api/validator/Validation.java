package co.edu.uco.teqvim.api.validator;

public interface Validation<T> {

	Result execute(T data);

}