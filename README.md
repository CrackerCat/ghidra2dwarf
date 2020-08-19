# Ghidra2Dwarf

![](./ghidra2dwarf.png)

Inspired by: [dwarfexport](https://github.com/ALSchwalm/dwarfexport)

Ghidra2Dwarf is a ghidra plugin that allows to exports informations (such as functions,
decompiled code, types) from ghidra to dwarf sections inside ELF binaries.

More specifically it exports inside a source file named `${program}.c` all the decompiled
functions, and create an ELF binary named `${program}.sym.exe` that can be used to
do source code level debugging.

Example:

![](./img/gdb.png)

Inside gdb now you can use:

1. `list <function>` to display the function's source code.
2. `n` to step one source code line instruction.
3. `ni` to step one assembly instruction.

## Install

### Linux

```sh
git clone https://github.com/cesena/ghidra2dwarf.git
cd ghidra2dwarf
mkdir -p ~/.ghidra/.${GHIDRA_VERSION}/plugins
cp ./jnarated/target/libdwarf.jar ~/.ghidra/.${GHIDRA_VERSION}/plugins/
```

### Windows

TODO

## Run

In the script manager -> script directories add the `src` directory:

![](./img/script-directories.png)

And then run `ghidra2dwarf`:

![](./img/run-script.png)

### Headless mode

#### Linux

If you saved the project and ghidra is closed, you can launch [ghidra2dwarf.sh](./src/ghidra2dwarf.sh)
to run ghidra in headless mode and export the dwarf informations:

```
./src/ghidra2dwarf.sh <Project directory> <Project name> <Binary path> <Binary>
# Example: ./src/ghidra2dwarf.sh ~/.local/share/ghidra/ TEST ~/CTF/ chall
```

#### Windows

TODO

## Known issues

* If the ELF binary is PIE, you need to rebase the memory map to the address `0`:

![](./img/rebase-pie.gif)

* Sometimes you get an `IndexError`, try to re-run the script until it works.

