package com.epam.controller;

/**
 * Returns object corresponding by key.
 *
 */
public interface IFactory {

	Object getEntityByCode(String key);
}
