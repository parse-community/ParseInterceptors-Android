/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.parse.interceptors;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** package */ class IOUtils {

  private static final int EOF = -1;

  /**
   * The default buffer size ({@value}) to use for
   * {@link #copyLarge(InputStream, OutputStream)}
   */
  private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;


  /**
   * Closes a <code>Closeable</code> unconditionally.
   * <p>
   * Equivalent to {@link Closeable#close()}, except any exceptions will be ignored.
   * This is typically used in finally blocks.
   * <p>
   * Example code:
   * <pre>
   *   Closeable closeable = null;
   *   try {
   *       closeable = new FileReader("foo.txt");
   *       // process closeable
   *       closeable.close();
   *   } catch (Exception e) {
   *       // error handling
   *   } finally {
   *       IOUtils.closeQuietly(closeable);
   *   }
   * </pre>
   *
   * @param closeable the object to close, may be null or already closed
   * @since 2.0
   */
  public static void closeQuietly(final Closeable closeable) {
    try {
      if (closeable != null) {
        closeable.close();
      }
    } catch (final IOException ioe) {
      // ignore
    }
  }

  /**
   * Copy bytes from a large (over 2GB) <code>InputStream</code> to an
   * <code>OutputStream</code>.
   * <p>
   * This method buffers the input internally, so there is no need to use a
   * <code>BufferedInputStream</code>.
   * <p>
   * The buffer size is given by {@link #DEFAULT_BUFFER_SIZE}.
   *
   * @param input  the <code>InputStream</code> to read from
   * @param output  the <code>OutputStream</code> to write to
   * @return the number of bytes copied
   * @throws NullPointerException if the input or output is null
   * @throws IOException if an I/O error occurs
   * @since 1.3
   */
  public static long copyLarge(InputStream input, OutputStream output)
          throws IOException {
    return copyLarge(input, output, new byte[DEFAULT_BUFFER_SIZE]);
  }

  /**
   * Copy bytes from a large (over 2GB) <code>InputStream</code> to an
   * <code>OutputStream</code>.
   * <p>
   * This method uses the provided buffer, so there is no need to use a
   * <code>BufferedInputStream</code>.
   * <p>
   *
   * @param input  the <code>InputStream</code> to read from
   * @param output  the <code>OutputStream</code> to write to
   * @param buffer the buffer to use for the copy
   * @return the number of bytes copied
   * @throws NullPointerException if the input or output is null
   * @throws IOException if an I/O error occurs
   * @since 2.2
   */
  public static long copyLarge(InputStream input, OutputStream output, byte[] buffer)
          throws IOException {
    long count = 0;
    int n = 0;
    while (EOF != (n = input.read(buffer))) {
      output.write(buffer, 0, n);
      count += n;
    }
    return count;
  }
}

