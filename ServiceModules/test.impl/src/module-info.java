module test.impl {
//    requires test.spi;
//    provides test.spi.TestService with test.impl.TestProvider;

    /*
    requires test.spi;
    //provides test.spi.TestService with test.impl.TestProvider;
    //provides test.spi.TestService with test.impl.TestProviderTwo;// compiler error
    provides test.spi.TestService with test.impl.TestProvider, test.impl.TestProviderTwo;
  */

    /*
    requires test.spi;
    provides test.spi.TestService with test.impl.TestProvider, test.impl.TestProviderTwo,
    test.impl.TestProviderFactory;
     */

    // Since the output is random, just mention factory which takes care of testprovider and testprovider2.
    /*
    requires test.spi;
    provides test.spi.TestService with test.impl.TestProviderFactory;
     */

    /*
    requires test.spi;
    provides test.spi.TestService with test.impl.TestProviderFactory, test.impl.TestProviderTwo;
     */

    //  Intellij is implying that there is no problem with directives as declared but we get
    //  a warning on line 1 on build stating "Service interface provided but not exported or used .
    //  Ok lets remove the added new provides and build, run
    // Now, again we get the same warning on "a" and No provider provided output
    // The below is example of point 5 in Summary
    /*
    requires test.spi;
    provides test.spi.TestService with test.impl.TestProviderFactory, test.impl.TestProviderTwo;//a
	provides test.impl.EnhancedTestService with test.impl.TestProviderTwo;// line 1
     */

    /* Still gets No provider provided on execute
    requires test.spi;
    exports test.impl;
    provides test.spi.EnhancedTestService with test.impl.TestProviderTwo;
     */


    requires test.spi;
    exports test.impl;
    provides test.spi.TestService with test.impl.TestProviderTwo;
}